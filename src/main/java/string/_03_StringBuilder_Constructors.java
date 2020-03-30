package string;

import static common.utils.PrintUtil.println;

public class _03_StringBuilder_Constructors {

    public static void main(String[] args) {
        // StringBuilder(int capacity)
        StringBuilder sb = new StringBuilder(8); // 16 by default
        println(sb.capacity());
        sb.append("1234567890");
        println(sb.capacity());
        sb.append("1234567890");
        println(sb.capacity());
        sb.append("1234567890");
        sb.append("1234567890");
        println(sb.capacity());
    }

}