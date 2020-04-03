package containers.array;

import static utils.PrintUtil.println;

public class _127_FillingArrays {
    public static void main(String[] args) {
        int size = 6;
        boolean[] a1 = new boolean[size];
        byte[] a2 = new byte[size];
        char[] a3 = new char[size];
        short[] a4 = new short[size];
        int[] a5 = new int[size];
        long[] a6 = new long[size];
        float[] a7 = new float[size];
        double[] a8 = new double[size];
        String[] a9 = new String[size];
        Arrays.fill(a1, true);
        println("a1 = " + Arrays.toString(a1));
        Arrays.fill(a2, (byte) 11);
        println("a2 = " + Arrays.toString(a2));
        Arrays.fill(a3, 'x');
        println("a3 = " + Arrays.toString(a3));
        Arrays.fill(a4, (short) 17);
        println("a4 = " + Arrays.toString(a4));
        Arrays.fill(a5, 19);
        println("a5 = " + Arrays.toString(a5));
        Arrays.fill(a6, 23);
        println("a6 = " + Arrays.toString(a6));
        Arrays.fill(a7, 29);
        println("a7 = " + Arrays.toString(a7));
        Arrays.fill(a8, 47);
        println("a8 = " + Arrays.toString(a8));
        Arrays.fill(a9, "Hello");
        println("a9 = " + Arrays.toString(a9));
        // Manipulating ranges:
        Arrays.fill(a9, 3, 5, "World");
        println("a9 = " + Arrays.toString(a9));
    }
}