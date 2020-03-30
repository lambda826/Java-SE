package containers;

import static common.utils.PrintUtil.println;

// What you can do with a TreeSet.

public class _151_SortedSetDemo {
    public static void main(String[] args) {
        SortedSet<String> sortedSet = new TreeSet<String>();
        Collections.addAll(sortedSet, "one two three four five six seven eight".split(" "));
        println(sortedSet);
        String low = sortedSet.first();
        String high = sortedSet.last();
        println(low);
        println(high);
        Iterator<String> it = sortedSet.iterator();
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
        println(sortedSet.subSet(low, high));
        println(sortedSet.headSet(high));
        println(sortedSet.tailSet(low));
    }
}