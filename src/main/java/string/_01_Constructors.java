package string;

import static utils.PrintUtil.println;

public class _01_Constructors {

    public static void main(String[] args) {

        char[] chs = { 'a', 'b', 'c', 'd', 'e', 'f', 'g' };
        byte[] bytes = { 71, 72, 73, 74, 75, 76, 77, 78 };
        int[] ints = { 71, 72, 73, 74, 75, 76, 77, 78 };

        println(new String(chs)); // String(char[] value)
        println(new String(chs, 4, 2)); // String(char[] value, int offset, int count)

        println(new String(bytes)); // String(byte[] bytes)
        println(new String(bytes, 4, 2)); // String(byte[] bytes, int offset, int length)

        println(new String(ints, 4, 2)); // String(int[] codePoints, int offset, int count)

    }
}
