package common.utils;

import java.io.PrintStream;

public class PrintUtil {

    public static void print(Object obj) {
        System.out.print(obj);
    }

    public static void println(Object obj) {
        System.out.println(obj);
    }

    public static void println() {
        System.out.println();
    }


    public static void newLine() {
        System.out.println();
    }

    public static void printnb(Object obj) {
        System.out.println(obj);
    }

    public static PrintStream printf(String format, Object... args) {
        return System.out.printf(format, args);
    }
}
