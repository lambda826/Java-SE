package string;

import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Formatter;

public class _05_Formatter {

    static class _10_Format_Conversion {
        public static void main(String[] args) {
            Formatter f = new Formatter(System.out);

            char u = 'a';
            System.out.println("u = 'a'");
            f.format("s: %s\n", u);
            // f.format("d: %d\n", u);
            f.format("c: %c\n", u);
            f.format("b: %b\n", u);
            // f.format("f: %f\n", u);
            // f.format("e: %e\n", u);
            // f.format("x: %x\n", u);
            f.format("h: %h\n", u);

            int v = 121;
            System.out.println("v = 121");
            f.format("d: %d\n", v);
            f.format("c: %c\n", v);
            f.format("b: %b\n", v);
            f.format("s: %s\n", v);
            // f.format("f: %f\n", v);
            // f.format("e: %e\n", v);
            f.format("x: %x\n", v);
            f.format("h: %h\n", v);

            BigInteger w = new BigInteger("50000000000000");
            System.out.println("w = new BigInteger(\"50000000000000\")");
            f.format("d: %d\n", w);
            // f.format("c: %c\n", w);
            f.format("b: %b\n", w);
            f.format("s: %s\n", w);
            // f.format("f: %f\n", w);
            // f.format("e: %e\n", w);
            f.format("x: %x\n", w);
            f.format("h: %h\n", w);

            double x = 179.543;
            System.out.println("x = 179.543");
            // f.format("d: %d\n", x);
            // f.format("c: %c\n", x);
            f.format("b: %b\n", x);
            f.format("s: %s\n", x);
            f.format("f: %f\n", x);
            f.format("e: %e\n", x);
            // f.format("x: %x\n", x);
            f.format("h: %h\n", x);

            _10_Format_Conversion y = new _10_Format_Conversion();
            System.out.println("y = new Conversion()");
            // f.format("d: %d\n", y);
            // f.format("c: %c\n", y);
            f.format("b: %b\n", y);
            f.format("s: %s\n", y);
            // f.format("f: %f\n", y);
            // f.format("e: %e\n", y);
            // f.format("x: %x\n", y);
            f.format("h: %h\n", y);

            boolean z = false;
            System.out.println("z = false");
            // f.format("d: %d\n", z);
            // f.format("c: %c\n", z);
            f.format("b: %b\n", z);
            f.format("s: %s\n", z);
            // f.format("f: %f\n", z);
            // f.format("e: %e\n", z);
            // f.format("x: %x\n", z);
            f.format("h: %h\n", z);
        }
    }

    static class _07_Format_SimpleFormat {

        public static void main(String[] args) {
            int x = 5;
            double y = 5.332542;
            // The old way:
            System.out.println("Row 1: [" + x + " " + y + "]");
            // The new way:
            System.out.format("Row 1: [%d %f]\n", x, y);
            // or
            System.out.printf("Row 1: [%d %f]\n", x, y);
        }
    }

    static class _08_Format_Turtle {

        private String name;
        private Formatter f;

        public _08_Format_Turtle(String name, Formatter f) {
            this.name = name;
            this.f = f;
        }

        public void move(int x, int y) {
            f.format("%s The Turtle is at (%d, %d)\n", name, x, y);
        }

        public static void main(String[] args) {
            PrintStream outAlias = System.out;
            _08_Format_Turtle tommy = new _08_Format_Turtle("Tommy", new Formatter(System.out));
            _08_Format_Turtle terry = new _08_Format_Turtle("Terry", new Formatter(outAlias));
            tommy.move(0, 0);
            terry.move(4, 8);
            tommy.move(3, 4);
            terry.move(2, 5);
            tommy.move(3, 3);
            terry.move(3, 3);
        }
    }

    static class _09_Format_Specifiers_Receipt {

        private double total = 0;
        private Formatter f = new Formatter(System.out);

        public void printTitle() {
            f.format("%-15s %5s %10s\n", "Item", "Qty", "Price");
            f.format("%-15s %5s %10s\n", "----", "---", "-----");
        }

        public void println(String name, int qty, double price) {
            f.format("%-15.15s %5d %10.2f\n", name, qty, price);
            total += price;
        }

        public void printTotal() {
            f.format("%-15s %5s %10.2f\n", "Tax", "", total * 0.06);
            f.format("%-15s %5s %10s\n", "", "", "-----");
            f.format("%-15s %5s %10.2f\n", "Total", "", total * 1.06);
        }

        public static void main(String[] args) {
            _09_Format_Specifiers_Receipt receipt = new _09_Format_Specifiers_Receipt();
            receipt.printTitle();
            receipt.println("Jack's Magic Beans", 4, 4.25);
            receipt.println("Princess Peas", 3, 5.1);
            receipt.println("Three Bears Porridge", 1, 14.29);
            receipt.printTotal();
        }
    }

    static class _12_Format_Hex {

        public static String format(byte[] data) {
            StringBuilder result = new StringBuilder();
            int n = 0;
            for (byte b : data) {
                if (n % 16 == 0) {
                    result.append(String.format("%05X: ", n));
                }
                result.append(String.format("%02X ", b));
                n++;
                if (n % 16 == 0) {
                    result.append("\n");
                }
            }
            result.append("\n");
            return result.toString();
        }

        //    public static void main(String[] args) throws Exception {
        //        if (args.length == 0) {
        //            // Test by displaying this class file:
        //            System.out.println(format(BinaryFile.read("_112_Hex.class")));
        //        } else {
        //            System.out.println(format(BinaryFile.read(new File(args[0]))));
        //        }
        //    }
    }
}
