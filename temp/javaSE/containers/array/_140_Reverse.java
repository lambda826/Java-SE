package containers.array;

import java.util.Arrays;
import java.util.Collections;

import static utils.PrintUtil.println;

public class _140_Reverse {
    public static void main(String[] args) {
        _139_CompType[] a = _132_Generated.array(new _139_CompType[12], _139_CompType.generator());
        println("before sorting:");
        println(Arrays.toString(a));
        Arrays.sort(a, Collections.reverseOrder());
        println("after sorting:");
        println(Arrays.toString(a));
    }
}