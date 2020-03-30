package containers.collection.legacy;

import containers._113_Stack;

import java.util.LinkedList;
import java.util.Stack;

import static common.utils.PrintUtil.println;
import static utils.Print.printnb;

enum Month {
    JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER
}

public class _02_Stacks {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        for (Month m : Month.values()) {
            stack.push(m.toString());
        }
        println("stack = " + stack);
        // Treating a stack as a Vector:
        stack.addElement("The last line");
        println("element 5 = " + stack.elementAt(5));
        println("popping elements:");
        while (!stack.empty()) {
            printnb(stack.pop() + " ");
        }
        // Using a LinkedList as a Stack:
        LinkedList<String> lstack = new LinkedList<String>();
        for (Month m : Month.values()) {
            lstack.addFirst(m.toString());
        }
        println("lstack = " + lstack);
        while (!lstack.isEmpty()) {
            printnb(lstack.removeFirst() + " ");
        }
        // Using the Stack class from the Holding Your Objects Chapter:
        _113_Stack<String> stack2 = new _113_Stack<String>();
        for (Month m : Month.values()) {
            stack2.push(m.toString());
        }
        println("stack2 = " + stack2);
        while (!stack2.empty()) {
            printnb(stack2.pop() + " ");
        }
    }
}