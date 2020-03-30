//package containers;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.List;
//
//import static common.utils.PrintUtil.println;
//
//public class _147_CollectionMethods {
//    public static void main(String[] args) {
//        Collection<String> c = new ArrayList<String>();
//        c.addAll(_144_Countries.names(6));
//        c.add("ten");
//        c.add("eleven");
//        println(c);
//        // Make an array from the List:
//        Object[] array = c.toArray();
//        // Make a String array from the List:
//        String[] str = c.toArray(new String[0]);
//        // Find max and min elements; this means different things depending on the way the Comparable interface is implemented:
//        println("Collections.max(c) = " + Collections.max(c));
//        println("Collections.min(c) = " + Collections.min(c));
//        // Add a Collection to another Collection
//        Collection<String> c2 = new ArrayList<String>();
//        c2.addAll(_144_Countries.names(6));
//        c.addAll(c2);c2
//        println(c);
//        c.remove(_144_Countries.DATA[0][0]);
//        println(c);
//        c.remove(_144_Countries.DATA[1][0]);
//        println(c);
//        // Remove all components that are in the argument collection:
//        c.removeAll(c2);
//        println(c);
//        c.addAll(c2);
//        println(c);
//        // Is an element in this Collection?
//        String val = _144_Countries.DATA[3][0];
//        println("c.contains(" + val + ") = " + c.contains(val));
//        // Is a Collection in this Collection?
//        println("c.containsAll(c2) = " + c.containsAll(c2));
//        Collection<String> c3 = ((List<String>) c).subList(3, 5);
//        // Keep all the elements that are in both c2 and c3 (an intersection of sets):
//        c2.retainAll(c3);
//        println(c2);
//        // Throw away all the elements in c2 that also appear in c3:
//        c2.removeAll(c3);
//        println("c2.isEmpty() = " + c2.isEmpty());
//        c = new ArrayList<String>();
//        c.addAll(_144_Countries.names(6));
//        println(c);
//        // Remove all elements
//        c.clear();
//        println("after c.clear():" + c);
//    }
//}