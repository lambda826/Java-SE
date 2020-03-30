package stream.refactoring;

import static common.utils.PrintUtil.println;

public class StrategyDemo {

    // Demo
    public static void main(String[] args) {
        // Old
        new Validator(new IsNumeric()).validate("aaaa");
        new Validator(new IsAllLowerCase()).validate("bbbb");

        // New, lambda
        new Validator((String s) -> s.matches("\\d+")).validate("aaaa");
        new Validator((String s) -> s.matches("[a-z]+")).validate("bbbb");

        // New strategy
        new Validator(StrategyDemo::isAllLowerCase).validate("aaaa");
        new Validator(StrategyDemo::isNumeric).validate("aaaa");

    }

    // Static method for reference
    public static boolean isAllLowerCase(String s) {
        return s.matches("[a-z]+");
    }

    // Static method for reference
    public static boolean isNumeric(String s) {
        return s.matches("\\d+");
    }

    // Abstract strategy
    @FunctionalInterface
    interface ValidationStrategy {
        boolean execute(String s);
    }

    // Client
    static private class Validator {
        private final ValidationStrategy strategy;

        public Validator(ValidationStrategy v) {
            strategy = v;
        }

        public void validate(String s) {
            println(strategy.execute(s));
        }
    }

    // Concrete stragety
    static private class IsAllLowerCase implements ValidationStrategy {
        @Override
        public boolean execute(String s) {
            return s.matches("[a-z]+");
        }
    }

    // Concrete stragety
    static private class IsNumeric implements ValidationStrategy {
        @Override
        public boolean execute(String s) {
            return s.matches("\\d+");
        }
    }

}
