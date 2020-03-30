package containers;

import java.util.Stack;

public class _115_StackCollision {
    public static void main(String[] args) {
        _113_Stack<String> stack = new _113_Stack<String>();
        for (String s : "My dog has fleas".split(" ")) {
            stack.push(s);
        }
        while (!stack.empty()) {
            System.out.println(stack.pop() + " ");
        }
        System.out.println();
        Stack<String> stack2 = new Stack<String>();
        for (String s : "My dog has fleas".split(" ")) {
            stack2.push(s);
        }
        while (!stack2.empty()) {
            System.out.println(stack2.pop() + " ");
        }
    }
}