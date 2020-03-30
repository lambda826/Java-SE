package dataAccess.jdbc.popg;

import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

@Builder
@Getter
public class CalculateRefundRequest {
    private String purchaseId;
    private long marketplaceId;
    private long merchantId;
    private String asin;
    private String sku;
    private long fulfillmentManagerId;
    private String listingType;
    private String discriminator;
    private String plaItemType;
    private String planItemSubtype;

    private Timestamp startTime;
    private double lowestPirce;
    private double ourCurrentPrice;

    @Override
    public String toString() {
        return new StringBuilder().append(purchaseId).append(",").append(marketplaceId).append(",").append(merchantId).append(",").append(asin).append(",").append(sku).append(",").append(fulfillmentManagerId).append(",").append(listingType)
                                  .append(",").append(discriminator).append(",").append(plaItemType).append(",").append(planItemSubtype).append(",").append(startTime).append(",").append(lowestPirce).append(",").append(ourCurrentPrice).toString();
    }
}
