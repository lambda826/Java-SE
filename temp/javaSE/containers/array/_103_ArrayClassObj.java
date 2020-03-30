//: initialization/ArrayClassObj.java
// Creating an array of nonprimitive objects.
package containers.array;


import java.util.Arrays;
import java.util.Random;

import static common.utils.PrintUtil.println;

public class _103_ArrayClassObj {
    public static void main(String[] args) {
        Random rand = new Random(47);
        Integer[] a = new Integer[rand.nextInt(20)];
        println("length of a = " + a.length);
        for (int i = 0; i < a.length; i++) {
            // Autoboxing
            a[i] = rand.nextInt(500);
        }
        println(Arrays.toString(a));
    }
}