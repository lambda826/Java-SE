package containers.collection.collections;

import containers._144_Countries;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import static utils.PrintUtil.println;

public class _03_ReadOnly {
    static Collection<String> data = new ArrayList<String>(_144_Countries.names(6));

    public static void main(String[] args) {
        Collection<String> c = Collections.unmodifiableCollection(new ArrayList<String>(data));
        // Reading is OK
        println(c);
        // Can't change it
        //! c.add("one"); 

        List<String> a = Collections.unmodifiableList(new ArrayList<String>(data));
        ListIterator<String> lit = a.listIterator();
        // Reading is OK
        println(lit.next());
        // Can't change it
        //! lit.add("one"); 

        Set<String> s = Collections.unmodifiableSet(new HashSet<String>(data));
        // Reading is OK
        println(s);
        // Can't change it
        //! s.add("one"); 

        // For a SortedSet:
        Set<String> ss = Collections.unmodifiableSortedSet(new TreeSet<String>(data));

        Map<String, String> m = Collections.unmodifiableMap(new HashMap<String, String>(_144_Countries.capitals(6)));
        // Reading is OK
        println(m);
        //! m.put("Ralph", "Howdy!");

        // For a SortedMap:
        Map<String, String> sm = Collections.unmodifiableSortedMap(new TreeMap<String, String>(_144_Countries.capitals(6)));
    }
}