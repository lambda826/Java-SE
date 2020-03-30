package containers.array;

import static common.utils.PrintUtil.println;

public class _102_ArrayNew {
    public static void main(String[] args) {
        int[] a;
        Random rand = new Random(47);
        a = new int[rand.nextInt(20)];
        println("length of a = " + a.length);
        println(Arrays.toString(a));
    }
}