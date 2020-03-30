//package containers.array;
//
//import java.util.Arrays;
//import java.util.Comparator;
//
//import static common.utils.PrintUtil.println;
//
//class CompTypeComparator implements Comparator<_139_CompType> {
//    public int compare(_139_CompType o1, _139_CompType o2) {
//        return o1.j - o2.j;
//    }
//}
//
//public class _141_ComparatorTest {
//    public static void main(String[] args) {
//        _139_CompType[] a = _132_Generated.array(new _139_CompType[12], _139_CompType.generator());
//        println("before sorting:");
//        println(Arrays.toString(a));
//        Arrays.sort(a, new CompTypeComparator());
//        println("after sorting:");
//        println(Arrays.toString(a));
//    }
//}