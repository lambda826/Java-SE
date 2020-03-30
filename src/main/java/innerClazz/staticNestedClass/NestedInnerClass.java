package innerClazz.staticNestedClass;

import innerClazz.Contents;
import innerClazz.Destination;

public class NestedInnerClass {

    private int outerVal;

    public static void main(String[] args) {
        Contents c = new NestedInnerClass().contents();
        Destination d = destination("Tasmania");
    }

    public Contents contents() {
        return new ParcelContents();
    }

    public static Destination destination(String s) {
        return new ParcelDestination(s);
    }

    protected static class ParcelDestination implements Destination {
        static int x = 10;
        private String label;

        private ParcelDestination(String whereTo) {
            // You can’t access a non-static outer-class object from an object of a nested class
            // outerVal = 1;
            label = whereTo;
        }

        // Nested classes can contain other static elements:
        public static void f() {
        }

        @Override
        public String readLabel() {
            return label;
        }

        static class AnotherLevel {
            static int x = 10;

            public static void f() {
            }
        }
    }

    private class ParcelContents implements Contents {
        private int i = 11;

        // private static in cannotBeStatic;

        @Override
        public int value() {
            return i;
        }
    }
}
