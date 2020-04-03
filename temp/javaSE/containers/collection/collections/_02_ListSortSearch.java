package containers.collection.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import static utils.PrintUtil.println;

// Sorting and searching Lists with Collections utilities.

public class _02_ListSortSearch {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(_01_Utilities.list);
        list.addAll(_01_Utilities.list);
        println(list);
        Collections.shuffle(list, new Random(47));
        println("Shuffled: " + list);
        // Use a ListIterator to trim off the last elements:
        ListIterator<String> it = list.listIterator(10);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
        println("Trimmed: " + list);
        Collections.sort(list);
        println("Sorted: " + list);
        String key = list.get(7);
        int index = Collections.binarySearch(list, key);
        println("Location of " + key + " is " + index + ", list.get(" + index + ") = " + list.get(index));
        Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
        println("Case-insensitive sorted: " + list);
        key = list.get(7);
        index = Collections.binarySearch(list, key, String.CASE_INSENSITIVE_ORDER);
        println("Location of " + key + " is " + index + ", list.get(" + index + ") = " + list.get(index));
    }
}