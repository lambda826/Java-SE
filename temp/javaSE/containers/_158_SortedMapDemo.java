package containers;

import java.util.Iterator;
import java.util.TreeMap;

import static common.utils.PrintUtil.println;

// What you can do with a TreeMap.

public class _158_SortedMapDemo {
    public static void main(String[] args) {
        TreeMap<Integer, String> sortedMap = new TreeMap<Integer, String>(new _146_CountingMapData(10));
        println(sortedMap);
        Integer low = sortedMap.firstKey();
        Integer high = sortedMap.lastKey();
        println(low);
        println(high);
        Iterator<Integer> it = sortedMap.keySet().iterator();
        for (int i = 0; i <= 6; i++) {
            if (i == 3) {
                low = it.next();
            }
            if (i == 6) {
                high = it.next();
            } else {
                it.next();
            }
        }
        println(low);
        println(high);
        println(sortedMap.subMap(low, high));
        println(sortedMap.headMap(high));
        println(sortedMap.tailMap(low));
    }
}