/**
 *  @author: Yunxiang He
 *  @date  : 2018-07-27 17:19
 */

package containers.map;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

//A comparator that compares last names.  
class CompLastNames implements Comparator<String> {
    public int compare(String aStr, String bStr) {
        int i, j;

        // Find index of beginning of last name. 
        i = aStr.lastIndexOf(' ');
        j = bStr.lastIndexOf(' ');

        return aStr.substring(i).compareToIgnoreCase(bStr.substring(j));
    }
}

//Sort by entire name when last names are equal.
class CompThenByFirstName implements Comparator<String> {
    public int compare(String aStr, String bStr) {
        return aStr.compareToIgnoreCase(bStr);
    }
}

public class _216_TreeMapDemo2A {
    public static void main(String args[]) {
        // Use thenComparing() to create a comparator that compares last names, then compares entire name when last names match.
        CompLastNames compLN = new CompLastNames();
        Comparator<String> compLastThenFirst = compLN.thenComparing(new CompThenByFirstName());

        // Create a tree map. 
        TreeMap<String, Double> tm = new TreeMap<String, Double>(compLastThenFirst);

        // Put elements to the map. 
        tm.put("John Doe", 3434.34);
        tm.put("Tom Smith", 123.22);
        tm.put("Jane Baker", 1378.00);
        tm.put("Tod Hall", 99.22);
        tm.put("Ralph Smith", -19.08);

        // Get a set of the entries.  
        Set<Map.Entry<String, Double>> set = tm.entrySet();

        // Display the elements. 
        for (Map.Entry<String, Double> me : set) {
            System.out.println(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
        System.out.println();

        // Deposit 1000 into John Doe's account. 
        double balance = tm.get("John Doe");
        tm.put("John Doe", balance + 1000);

        System.out.println("John Doe's new balance: " + tm.get("John Doe"));
    }
}