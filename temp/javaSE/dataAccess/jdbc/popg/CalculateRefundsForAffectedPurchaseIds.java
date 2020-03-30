package dataAccess.jdbc.popg;

import dataAccess.jdbc.DbUtil;
import javaSe.foundation.io.FileUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CalculateRefundsForAffectedPurchaseIds {

    private Timestamp throttleStartTime;
    private Timestamp throttleEndTime;
    private long marketplaceId;
    private long merchantId;
    Map<String, TreeMap<Timestamp, Double>> offerListingsMap = new HashMap<>();
    private final String lineItemsWithinTimeFrame_SQL = "SELECT "
                                                                + "purchase_id, asin"
                                                                + ""
                                                                + ""
                                                                + " FROM protected_line_items " + "WHERE is_completed = 't' AND marketplace_id = ? AND merchant_id = ? AND purchase_date >= ? And purchase_date < ? " + "ORDER BY purchase_date;";
    private final String asinPriceHistoryDesc_SQL = "SELECT asin, start_time, price_with_tax FROM protected_offer_listings WHERE asin = ? AND is_Preorderable = 't' AND marketplace_id = ? AND merchant_id = ? ORDER BY start_time DESC;";
    private final String order_header = "purchaseId,marketplaceId,merchantId,asin,sku,fulfillmentManagerId,listingType,discriminator,planItemType,planItemSubtype,startTime,lowestPrice,ourCurrentPrice";
    private final String directory = "tmp/calculateRefunds";
    private Timestamp tempStartTime;
    private double tempLowestPrice;
    private TreeMap<Timestamp, Double> dummyMap = new TreeMap<>();

    public void calculate(String line) throws IOException {
        FileUtil.createIfAbsent(directory);
        initiateInput(line.split(","));
        calculateRefunds();
    }

    private void calculateRefunds() {
        File purchaseInfos = FileUtil.createIfAbsent(directory, getFileName()).toFile();
        try (PrintWriter pw = new PrintWriter(purchaseInfos)) {
            pw.println(order_header);
            try (Connection connection = DbUtil.getConnection()) {
                processQueries(connection, pw);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void processQueries(Connection connection, PrintWriter pw) {
        try (PreparedStatement pstm = connection.prepareStatement(lineItemsWithinTimeFrame_SQL)) {
            pstm.setLong(1, marketplaceId);
            pstm.setLong(2, merchantId);
            pstm.setTimestamp(3, throttleStartTime);
            pstm.setTimestamp(4, throttleEndTime);
            // Line items within time frame
            ResultSet resultSet = pstm.executeQuery();
            // Constraints on query for protected offer listings
            String asin;
            double currentOurPrice;
            Timestamp purchaseDate;
            while (resultSet.next()) {
                asin = resultSet.getString("asin");
                currentOurPrice = resultSet.getDouble("current_our_price");
                purchaseDate = resultSet.getTimestamp("purchase_date");
                if (shouldRefund(connection, asin, purchaseDate, currentOurPrice)) {
                    CalculateRefundRequest refundRequest = CalculateRefundRequest.builder()
                                                                                 .purchaseId(resultSet.getString("purchase_Id"))
                                                                                 .marketplaceId(marketplaceId)
                                                                                 .merchantId(merchantId)
                                                                                 .asin(resultSet.getString("asin"))
                                                                                 .sku(resultSet.getString("sku"))
                                                                                 .fulfillmentManagerId(resultSet.getLong("fulfillment_manager_id"))
                                                                                 .listingType(resultSet.getString("listing_type"))
                                                                                 .discriminator(resultSet.getString("discriminator"))
                                                                                 .plaItemType("NULL")
                                                                                 .planItemSubtype("NULL")
                                                                                 .startTime(tempStartTime)
                                                                                 .lowestPirce(tempLowestPrice)
                                                                                 .ourCurrentPrice(resultSet.getDouble("current_our_price"))
                                                                                 .build();
                    pw.println(refundRequest);
                    // TODO: send request to CalculateRefund API
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean shouldRefund(Connection connection, String asin, Timestamp purchaseDate, double currentOurPrice) {
        boolean shouldRefund = false;
        TreeMap<Timestamp, Double> priceInfo = offerListingsMap.computeIfAbsent(asin, (k) -> getPriceHistoryByAsin(connection, asin));
        Map.Entry<Timestamp, Double> nextStartTimeEntry = priceInfo.higherEntry(purchaseDate);
        // If not recording best offer, then
        // return nextStartTimeEntry != null && currentOurPrice > nextStartTimeEntry.getValue();
        if (nextStartTimeEntry != null && currentOurPrice > nextStartTimeEntry.getValue()) {
            tempStartTime = nextStartTimeEntry.getKey();
            tempLowestPrice = nextStartTimeEntry.getValue();
            shouldRefund = true;
        }
        return shouldRefund;
    }

    private TreeMap<Timestamp, Double> getPriceHistoryByAsin(Connection connection, String asin) {
        TreeMap<Timestamp, Double> priceInfo = dummyMap;
        try (PreparedStatement pstm = connection.prepareStatement(asinPriceHistoryDesc_SQL)) {
            pstm.setString(1, asin);
            pstm.setLong(2, marketplaceId);
            pstm.setLong(3, merchantId);
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                if (priceInfo == dummyMap) {
                    priceInfo = new TreeMap<>();
                }
                double currentPriceWithTax = resultSet.getDouble("price_with_tax");
                Timestamp currentStartTime = resultSet.getTimestamp("start_time");
                Map.Entry<Timestamp, Double> nextStartTimeEntry = priceInfo.higherEntry(currentStartTime);
                priceInfo.put(currentStartTime, nextStartTimeEntry != null && nextStartTimeEntry.getValue() < currentPriceWithTax ? nextStartTimeEntry.getValue() : currentPriceWithTax);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return priceInfo;
    }

    private String getFileName() {
        SimpleDateFormat formatter = new SimpleDateFormat("YYYYMMdd");
        return "PurchaseInfos (" + formatter.format(throttleStartTime) + "-" + formatter.format(throttleEndTime) + ").csv";
    }

    private void initiateInput(String[] strs) {
        throttleStartTime = Timestamp.valueOf(strs[0]);
        throttleEndTime = Timestamp.valueOf(strs[1]);
        marketplaceId = Long.parseLong(strs[2]);
        merchantId = Long.parseLong(strs[3]);
    }

    public static void main(String[] args) throws IOException {
        CalculateRefundsForAffectedPurchaseIds c = new CalculateRefundsForAffectedPurchaseIds();
        c.calculate("2018-01-01 00:00:00,2019-08-01 00:00:00,6,12");
    }
}
