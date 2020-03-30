/**
 *  @author: Yunxiang He
 *  @date  : 2018-10-21
 */

package common.utils;

public class ArrayUtils {

    public static void swap(Object[] A, int i, int j) {
        Object swap = A[i];
        A[i] = A[j];
        A[j] = swap;
    }

    public static void swap(int[] A, int i, int j) {
        int swap = A[i];
        A[i] = A[j];
        A[j] = swap;
    }

}
