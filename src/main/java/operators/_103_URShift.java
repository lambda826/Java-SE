package operators;

import static utils.PrintUtil.println;

public class _103_URShift {
    public static void main(String[] args) {
        int i = -1;
        println(Integer.toBinaryString(i));
        i >>>= 10;
        println(Integer.toBinaryString(i));
        long l = -1;
        println(Long.toBinaryString(l));
        l >>>= 10;
        println(Long.toBinaryString(l));
        // There is a problem, however, with the unsigned right shift combined with assignment. 
        // If you use it with byte or short, you don’t get the correct results. 
        // Instead, these are promoted to int and right shifted, but then truncated as they are assigned back into their variables, so you get -1 in those cases
        short s = -1;
        println(Integer.toBinaryString(s));
        s >>>= 20;
        println(Integer.toBinaryString(s));
        byte b = -1;
        println(Integer.toBinaryString(b));
        b >>>= 10;
        println(Integer.toBinaryString(b));
        b = -1;
        println(Integer.toBinaryString(b));
        println(Integer.toBinaryString(b >>> 10));
    }
}