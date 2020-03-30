package containers.array;

import generics._109_Generator;

import java.util.Arrays;

import static common.utils.PrintUtil.println;

public class _143_ArraySearching {
    public static void main(String[] args) {
        _109_Generator<Integer> gen = new _130_RandomGenerator.Integer(1000);
        int[] a = _134_ConvertTo.primitive(_132_Generated.array(new Integer[25], gen));
        Arrays.sort(a);
        println("Sorted array: " + Arrays.toString(a));
        while (true) {
            int r = gen.next();
            int location = Arrays.binarySearch(a, r);
            if (location >= 0) {
                println("Location of " + r + " is " + location + ", a[" + location + "] = " + a[location]);
                break;
            }
        }
    }
}