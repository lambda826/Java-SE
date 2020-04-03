package containers.array;

import java.util.Arrays;

import static utils.PrintUtil.println;

public class _137_CopyingArrays {
    public static void main(String[] args) {
        int[] i = new int[7];
        int[] j = new int[10];
        Arrays.fill(i, 47);
        Arrays.fill(j, 99);
        println("i = " + Arrays.toString(i));
        println("j = " + Arrays.toString(j));
        // source array, the offset into the source array from whence to start copying, the destination array, the offset into the destination array where the copying begins, and the number of elements to copy. 
        System.arraycopy(i, 0, j, 0, i.length);
        println("j = " + Arrays.toString(j));
        int[] k = new int[5];
        Arrays.fill(k, 103);
        System.arraycopy(i, 0, k, 0, k.length);
        println("k = " + Arrays.toString(k));
        Arrays.fill(k, 103);
        System.arraycopy(k, 0, i, 0, k.length);
        println("i = " + Arrays.toString(i));
        // Objects:
        Integer[] u = new Integer[10];
        Integer[] v = new Integer[5];
        Arrays.fill(u, new Integer(47));
        Arrays.fill(v, new Integer(99));
        println("u = " + Arrays.toString(u));
        println("v = " + Arrays.toString(v));
        System.arraycopy(v, 0, u, u.length / 2, v.length);
        println("u = " + Arrays.toString(u));
    }
}