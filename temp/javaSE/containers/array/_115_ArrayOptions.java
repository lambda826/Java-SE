package containers.array;

import common.obj.BerylliumSphere;

import java.util.Arrays;

import static common.utils.PrintUtil.println;

public class _115_ArrayOptions {
    public static void main(String[] args) {
        // Arrays of objects:
        // Local uninitialized variable
        BerylliumSphere[] a;
        BerylliumSphere[] b = new BerylliumSphere[5];
        // The references inside the array are automatically initialized to null:
        println("b: " + Arrays.toString(b));
        BerylliumSphere[] c = new BerylliumSphere[4];
        for (int i = 0; i < c.length; i++) {
            // Can test for null reference
            if (c[i] == null) {
                c[i] = new BerylliumSphere();
            }
        }
        // Aggregate initialization:
        BerylliumSphere[] d = { new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere() };
        // Dynamic aggregate initialization:
        a = new BerylliumSphere[] { new BerylliumSphere(), new BerylliumSphere(), };
        // (Trailing comma is optional in both cases)
        println("a.length = " + a.length);
        println("b.length = " + b.length);
        println("c.length = " + c.length);
        println("d.length = " + d.length);
        a = d;
        println("a.length = " + a.length);

        // Arrays of primitives:
        // Null reference
        int[] e;
        int[] f = new int[5];
        // The primitives inside the array are automatically initialized to zero:
        println("f: " + Arrays.toString(f));
        int[] g = new int[4];
        for (int i = 0; i < g.length; i++) {
            g[i] = i * i;
        }
        int[] h = { 11, 47, 93 };
        // Compile error: variable e not initialized:
        //!println("e.length = " + e.length);
        println("f.length = " + f.length);
        println("g.length = " + g.length);
        println("h.length = " + h.length);
        e = h;
        println("e.length = " + e.length);
        e = new int[] { 1, 2 };
        println("e.length = " + e.length);
    }
}