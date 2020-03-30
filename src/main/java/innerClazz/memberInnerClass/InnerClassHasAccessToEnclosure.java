package innerClazz.memberInnerClass;

import static common.utils.PrintUtil.println;

interface Selector {
    boolean end();

    Object current();

    void next();
}

/**
 * When you create an inner class, an object of that inner class has a link to the enclosing object
 */
public class InnerClassHasAccessToEnclosure {

    private Object[] items;
    private int next = 0;

    public InnerClassHasAccessToEnclosure(int size) {
        items = new Object[size];
    }

    public static void main(String[] args) {
        InnerClassHasAccessToEnclosure sequence = new InnerClassHasAccessToEnclosure(10);
        for (int i = 0; i < 10; ++i) {
            sequence.add(Integer.toString(i));
        }
        Selector selector = sequence.selector();
        while (!selector.end()) {
            println(selector.current() + " ");
            selector.next();
        }
    }

    public void add(Object x) {
        if (next < items.length) {
            items[next++] = x;
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    // Inner class upcasting
    private class SequenceSelector implements Selector {
        private int i = 0;

        // Has the access to the closure element items
        public boolean end() {
            return i == items.length;
        }

        // Has the access to the closure element items
        public Object current() {
            return items[i];
        }

        // Has the access to the closure element items
        public void next() {
            if (i < items.length) {
                ++i;
            }
        }
    }
}