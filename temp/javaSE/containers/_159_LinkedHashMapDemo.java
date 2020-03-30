//package containers;
//
//import java.util.LinkedHashMap;
//
//import static common.utils.PrintUtil.println;
//
//public class _159_LinkedHashMapDemo {
//    public static void main(String[] args) {
//        LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap<Integer, String>(new _146_CountingMapData(9));
//        println(linkedMap);
//        // Least-recently-used order:
//        linkedMap = new LinkedHashMap<Integer, String>(16, 0.75f, true);
//        linkedMap.putAll(new _146_CountingMapData(9));
//        println(linkedMap);
//        for (int i = 0; i < 6; i++) {
//            linkedMap.get(i);
//        }
//        println(linkedMap);
//        linkedMap.get(0);
//        println(linkedMap);
//    }
//}