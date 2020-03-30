package lambda.behavior_parameterization;

import common.pojos.fruit.Apple;

public class ApplePrinterImpl {

    // ApplePrinter Strategy #1
    public static class AppleSimplePrinter implements ApplePrinter {
        public String accept(Apple apple) {
            return "An apple of " + apple.getWeight() + "g";
        }
    }

    // ApplePrinter Strategy #2
    public static class AppleFancyPrinter implements ApplePrinter {
        public String accept(Apple apple) {
            return "A " + (apple.getWeight() > 150 ? "heavy" : "light") + " " + apple.getColor() + " apple";
        }
    }

}
