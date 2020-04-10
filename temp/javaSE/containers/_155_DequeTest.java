package containers;

import static utils.Print.printnb;
import static utils.PrintUtil.println;

public class _155_DequeTest {
    static void fillTest(_154_Deque<Integer> deque) {
        for (int i = 20; i < 27; i++) {
            deque.addFirst(i);
        }
        for (int i = 50; i < 55; i++) {
            deque.addLast(i);
        }
    }

    public static void main(String[] args) {
        _154_Deque<Integer> di = new _154_Deque<Integer>();
        fillTest(di);
        println(di);
        while (di.size() != 0) {
            printnb(di.removeFirst() + " ");
        }
        println();
        fillTest(di);
        while (di.size() != 0) {
            printnb(di.removeLast() + " ");
        }
    }
}