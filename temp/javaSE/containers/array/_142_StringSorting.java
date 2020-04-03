//package containers.array;
//
//import java.util.Arrays;
//import java.util.Collections;
//
//import static utils.PrintUtil.println;
//
//public class _142_StringSorting {
//    public static void main(String[] args) {
//        String[] sa = _132_Generated.array(new String[20], new _130_RandomGenerator.String(5));
//        println("Before sort: " + Arrays.toString(sa));
//        Arrays.sort(sa);
//        println("After sort: " + Arrays.toString(sa));
//        Arrays.sort(sa, Collections.reverseOrder());
//        println("Reverse sort: " + Arrays.toString(sa));
//        Arrays.sort(sa, String.CASE_INSENSITIVE_ORDER);
//        println("Case-insensitive sort: " + Arrays.toString(sa));
//    }
//}