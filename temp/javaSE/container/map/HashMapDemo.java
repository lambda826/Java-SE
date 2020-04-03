/**
 * @author heyx8
 * @date 06/30/2019
 */

package container.map;

import utils.PrintUtil;

import static utils.PrintUtil.println;
import static java.util.Map.entry;

Util.println;

public class HashMapDemo {

    private static Map<String, Integer> unmodifiableMap1;
    private static Map<String, String> unmodifiableMap2;
    private static Map<String, Integer> entries1;
    private static Map<String, String> entries2;
    private static Map<String, ArrayList<Integer>> entries3;

    /**
     * Returns an unmodifiable map containing keys and values
     *
     * static <K,​V> Map<K,​V> of() 
     * static <K,​V> Map<K,​V> of​(K k1, V v1)
     * static <K,​V> Map<K,​V> of​(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10)
     * static <K,​V> Map<K,​V> ofEntries​(Map.Entry<? extends K, ​? extends V>... entries)
     */
    static {
        unmodifiableMap1 = Map.of("key1", 1, "key2", 2, "key3", 3);
        unmodifiableMap2 = Map.ofEntries(entry("Raphael", "Star Wars"), entry("Cristina", "Matrix"), entry("Olivia", "James Bond"));
        entries1 = new HashMap<>(unmodifiableMap1);
        entries2 = new HashMap<>(unmodifiableMap2);
        entries3 = new HashMap<>();
    }

    /**
     * default void forEach​(BiConsumer<? super K,​ ? super V> action)
     */
    public static void forEachMethod() {
        // Traditionally
        for (Map.Entry<String, Integer> entry : entries1.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            println("key: " + key + "value: " + value);
        }
        // New approach
        entries1.forEach((key, value) -> println("key: " + key + "value: " + value));
    }

    /**
     * static <K extends Comparable<? super K>, ​V> Comparator<Map.Entry<K, ​V>> comparingByKey()
     * static <K,​ V extends Comparable<? super V>> Comparator<Map.Entry<K,​ V>> comparingByValue()
     * static <K,​ V> Comparator<Map.Entry<K, ​V>> comparingByKey​(Comparator<? super K> cmp)
     * static <K, ​V> Comparator<Map.Entry<K, ​V>> comparingByValue​(Comparator<? super V> cmp)
     */
    public static void sortingMethod() {
        entries2.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEachOrdered(PrintUtil::println);
    }

    /**
     * default V getOrDefault​(Object key, V defaultValue)
     * default V computeIfAbsent​(K key, Function<? super K,​ ? extends V> mappingFunction)
     * default V computeIfPresent​(K key, BiFunction<? super K,​ ? super V, ​? extends V> remappingFunction)
     * default V compute​(K key, BiFunction<? super K, ​? super V,​ ? extends V> remappingFunction)
     */
    public static void computePatterns() {
        String newVal = entries2.computeIfAbsent("key1", (value) -> value + " " + value);
        println(newVal);

        entries3.getOrDefault("key1", new ArrayList<>());
        println(entries3);

        entries3.computeIfAbsent("key1", value -> new ArrayList<>()).add(1);
        entries3.computeIfAbsent("key1", value -> new ArrayList<>()).add(2);
        println(entries3);

        entries3.computeIfPresent("key1", (key, value) -> new ArrayList<>()).add(3);
        println(entries3);

        entries3.compute("key1", (key, value) -> new ArrayList<>()).add(4);
        println(entries3);

        entries3.compute("key2", (key, value) -> new ArrayList<>()).add(5);
        println(entries3);
    }

    /**
     * default boolean remove​(Object key, Object value)
     */
    public static void removePatterns() {
        println(entries1);
        entries1.remove("key1", 2);
        entries1.remove("key4", 2);
        println(entries1);
    }

    /**
     * default V replace​(K key, V value)
     * The default implementation is equivalent to, for this map:
     * if (map.containsKey(key)) {
     * return map.put(key, value);
     * } else
     * return null;
     * default boolean replace​(K key, V oldValue, V newValue)
     * The default implementation is equivalent to, for this map:
     * if (map.containsKey(key) && Objects.equals(map.get(key), value)) {
     * map.put(key, newValue);
     * return true;
     * } else
     * return false;
     * default void replaceAll​(BiFunction<? super K, ​? super V,​ ? extends V> function)
     * The default implementation is equivalent to, for this map:
     * for (Map.Entry<K, V> entry : map.entrySet())
     * entry.setValue(function.apply(entry.getKey(), entry.getValue()));
     */
    public static void replacePatterns() {
        Integer i1 = entries1.replace("key1", 6);
        Integer i2 = entries1.replace("key1", 4);
        println(i1 + " " + i2);
    }

    /**
     * static <K,​V> Map<K,​V> copyOf​(Map<? extends K,​ ? extends V> map)
     * since 10
     */
    public static void copyOfDemo() {

    }


    /**
     * default V merge​(K key, V value, BiFunction<? super V,​ ? super V,​ ? extends V> remappingFunction)
     * The default implementation is equivalent to performing the following steps for this map, then returning the current value or null if absent:
     *     V oldValue = map.get(key);
     *     V newValue = (oldValue == null) ? value : remappingFunction.apply(oldValue, value);
     *     if (newValue == null)
     *         map.remove(key);
     *     else
     *         map.put(key, newValue);
     */
    public static void mergeDemo() {
        Map<String, String> family = Map.ofEntries(entry("Teo", "Star Wars"), entry("Cristina", "James Bond"));

        // The code works well if you don't have duplicate keys
        Map<String, String> friends = Map.ofEntries(entry("Raphael", "Star Wars"));
        Map<String, String> everyone = new HashMap<>(family);
        everyone.putAll(friends);
        println(everyone);

        // Duplicate key: Cristina
        Map<String, String> friends2 = Map.ofEntries(entry("Raphael", "Star Wars"), entry("Cristina", "Matrix"));

        Map<String, String> everyone2 = new HashMap<>(family);
        friends2.forEach((k, _2nParamForMerge) -> everyone2.merge(k, _2nParamForMerge, (oldValueByKey, movie2) -> oldValueByKey + " & " + movie2));
        println(everyone2);
    }

    public static void main(String[] args) {
        mergeDemo2();
    }

    public static void mergeDemo2() {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        //        map.put(0, new HashSet<>(){{add(1); add(2);}});
        Set<Integer> set2 = new HashSet<>() {{
            add(1);
            add(3);
        }};

        //        map.merge(0, set2, (oldSet, newSet) -> Sets.union(oldSet, newSet));
        println(map);
    }

}
