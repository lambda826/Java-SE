package string;

import java.util.Arrays;

import static utils.PrintUtil.println;

public class _02_StringAPIs {

    public static void checkLength() {
        String str = "  ";
        println(str.length());
        println(str.isEmpty());
        println(str.isBlank()); // boolean isBlank(), JDK 11
    }

    public static void chars() {
        String str = "abcdefg";
        char[] chars = new char[10];
        str.getChars(4, 7, chars, 0);// void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)
        println(Arrays.toString(chars));
        str.getChars(4, 7, chars, 2);// void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)
        println(Arrays.toString(chars));
    }


    public static void bytes() {
        String str = "abcdefg";
        byte[] bytes = str.getBytes();
        println(Arrays.toString(bytes));
        println(str.codePointAt(0));
    }

    public static void index() {
        String s = "Now is the time for all good men " + "to come to the aid of their country.";
        println(s);
        println("indexOf(t) = " + s.indexOf('t'));
        println("lastIndexOf(t) = " + s.lastIndexOf('t'));
        println("indexOf(the) = " + s.indexOf("the"));
        println("lastIndexOf(the) = " + s.lastIndexOf("the"));
        println("indexOf(t, 10) = " + s.indexOf('t', 10));
        println("lastIndexOf(t, 60) = " + s.lastIndexOf('t', 60));
        println("indexOf(the, 10) = " + s.indexOf("the", 10));
        println("lastIndexOf(the, 60) = " + s.lastIndexOf("the", 60));
    }

    public static void regexRelated() {
        // split
        // join
        println(String.join(" ", "Alpha", "Beta", "Gamma"));
        // match
        // replace
    }

    public static void stream() {
        String lambda = "temp/javaSE/lambda";

        lambda.chars().forEach(utils.PrintUtil::println);
        lambda.codePoints().forEach(utils.PrintUtil::println);
        (lambda + " \n" + lambda + " \n" + lambda).lines().forEach(utils.PrintUtil::println);

    }

    public static void main(String[] args) {
        bytes();
    }
}

