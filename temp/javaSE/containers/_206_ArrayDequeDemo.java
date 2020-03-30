/**
 *  @author: Yunxiang He
 *  @date  : 2018-07-16 04:37
 */

package containers;

import java.util.ArrayDeque;

public class _206_ArrayDequeDemo {
    public static void main(String args[]) {
        // Create a tree set. 
        ArrayDeque<String> adq = new ArrayDeque<String>();

        // Use an ArrayDeque like a stack.
        adq.push("A");
        adq.push("B");
        adq.push("D");
        adq.push("E");
        adq.push("F");

        System.out.println("Popping the stack: ");

        while (adq.peek() != null) {
            System.out.println(adq.pop() + " ");
        }

        System.out.println();
    }
}
