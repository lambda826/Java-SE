//package refactoring;
//
//import lombok.Getter;
//
//import java.util.Map;
//import java.util.function.Supplier;
//
//import static java.util.Map.entry;
//
//@Getter
//public class FactoryDemo {
//
//    final static private Map<String, Supplier<Product>> map = Map.ofEntries(entry("loan", Loan::new), entry("stock", Stock::new), entry("bond", Bond::new));
//
//    // Demo
//    public static void main(String[] args) {
//        Product p1 = ProductFactory.createProduct("loan");
//        Product p2 = ProductFactory.createProductLambda("loan");
//
//        Supplier<Product> loanSupplier = Loan::new;
//        Product p3 = loanSupplier.get();
//
//    }
//
//    private interface Product {
//    }
//
//    static private class ProductFactory {
//
//        // Old
//        public static Product createProduct(String name) {
//            switch (name) {
//                case "loan":
//                    return new Loan();
//                case "stock":
//                    return new Stock();
//                case "bond":
//                    return new Bond();
//                default:
//                    throw new RuntimeException("No such product " + name);
//            }
//        }
//
//        // New
//        public static Product createProductLambda(String name) {
//            Supplier<Product> p = map.get(name);
//            if (p != null) {
//                return p.get();
//            }
//            throw new RuntimeException("No such product " + name);
//        }
//    }
//
//    static private class Loan implements Product {
//    }
//
//    static private class Stock implements Product {
//    }
//
//    static private class Bond implements Product {
//    }
//
//}
