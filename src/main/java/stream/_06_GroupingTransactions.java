package stream;

import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static common.utils.PrintUtil.println;
import static java.util.stream.Collectors.groupingBy;

public class _06_GroupingTransactions {

    private enum Currency {
        EUR, USD, JPY, GBP, CHF
    }

    @Data
    private static class Transaction {
        private final Currency currency;
        private final double value;
    }

    private static List<Transaction> transactions = Arrays.asList(
            new Transaction(Currency.EUR, 1500.0),
            new Transaction(Currency.EUR, 1100.0),
            new Transaction(Currency.EUR, 5600.0),
            new Transaction(Currency.EUR, 6800.0),
            new Transaction(Currency.USD, 2300.0),
            new Transaction(Currency.USD, 4600.0),
            new Transaction(Currency.USD, 4500.0),
            new Transaction(Currency.GBP, 9900.0),
            new Transaction(Currency.GBP, 3200.0),
            new Transaction(Currency.JPY, 7800.0),
            new Transaction(Currency.JPY, 5700.0),
            new Transaction(Currency.CHF, 6700.0),
            new Transaction(Currency.CHF, 3400.0)
    );

    public static void main(String... args) {
        Map<Currency, List<Transaction>> transactionsByCurrencies = transactions.stream().collect(groupingBy(Transaction::getCurrency));
        println(transactionsByCurrencies);
    }


}
