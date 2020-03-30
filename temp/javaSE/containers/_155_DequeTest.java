package containers;

import static common.utils.PrintUtil.println;
import static utils.Print.printnb;

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