package containers;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

import static common.utils.PrintUtil.println;
import static utils.Print.printnb;

public class _157_Maps {
    public static void printKeys(Map<Integer, String> map) {
        printnb("Size = " + map.size() + ", ");
        printnb("Keys: ");
        println(map.keySet());
    }

    public static void test(Map<Integer, String> map) {
        println(map.getClass().getSimpleName());
        map.putAll(new _146_CountingMapData(25));
        // Map has 'Set' behavior for keys:
        map.putAll(new _146_CountingMapData(25));
        printKeys(map);
        // Producing a Collection of the values:
        printnb("Values: ");
        println(map.values());
        println(map);
        println("map.containsKey(11): " + map.containsKey(11));
        println("map.get(11): " + map.get(11));
        println("map.containsValue(\"F0\"): " + map.containsValue("F0"));
        Integer key = map.keySet().iterator().next();
        println("First key in map: " + key);
        map.remove(key);
        printKeys(map);
        map.clear();
        println("map.isEmpty(): " + map.isEmpty());
        map.putAll(new _146_CountingMapData(25));
        // Operations on the Set change the Map:
        map.keySet().removeAll(map.keySet());
        println("map.isEmpty(): " + map.isEmpty());
    }

    public static void main(String[] args) {
        test(new HashMap<Integer, String>());
        test(new TreeMap<Integer, String>());
        test(new LinkedHashMap<Integer, String>());
        test(new IdentityHashMap<Integer, String>());
        test(new ConcurrentHashMap<Integer, String>());
        test(new WeakHashMap<Integer, String>());
    }
}