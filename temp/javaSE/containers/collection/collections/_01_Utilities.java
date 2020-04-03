package containers.collection.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import static utils.PrintUtil.println;

// Simple demonstrations of the Collections utilities.

public class _01_Utilities {
    static List<String> list = Arrays.asList("one Two three Four five six one".split(" "));

    public static void main(String[] args) {
        println(list);
        println("'list' disjoint (Four)?: " + Collections.disjoint(list, Collections.singletonList("Four")));
        println("max: " + Collections.max(list));
        println("min: " + Collections.min(list));
        println("max w/ comparator: " + Collections.max(list, String.CASE_INSENSITIVE_ORDER));
        println("min w/ comparator: " + Collections.min(list, String.CASE_INSENSITIVE_ORDER));
        List<String> sublist = Arrays.asList("Four five six".split(" "));
        println("indexOfSubList: " + Collections.indexOfSubList(list, sublist));
        println("lastIndexOfSubList: " + Collections.lastIndexOfSubList(list, sublist));
        Collections.replaceAll(list, "one", "Yo");
        println("replaceAll: " + list);
        Collections.reverse(list);
        println("reverse: " + list);
        Collections.rotate(list, 3);
        println("rotate: " + list);
        List<String> source = Arrays.asList("in the matrix".split(" "));
        Collections.copy(list, source);
        println("copy: " + list);
        Collections.swap(list, 0, list.size() - 1);
        println("swap: " + list);
        Collections.shuffle(list, new Random(47));
        println("shuffled: " + list);
        Collections.fill(list, "pop");
        println("fill: " + list);
        println("frequency of 'pop': " + Collections.frequency(list, "pop"));
        List<String> dups = Collections.nCopies(3, "snap");
        println("dups: " + dups);
        println("'list' disjoint 'dups'?: " + Collections.disjoint(list, dups));
        // Getting an old-style Enumeration:
        Enumeration<String> e = Collections.enumeration(dups);
        Vector<String> v = new Vector<String>();
        while (e.hasMoreElements()) {
            v.addElement(e.nextElement());
        }
        // Converting an old-style Vector to a List via an Enumeration:
        ArrayList<String> arrayList = Collections.list(v.elements());
        println("arrayList: " + arrayList);
    }
}