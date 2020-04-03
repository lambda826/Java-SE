package innerClazz.LocalInnerClass;

import static utils.PrintUtil.println;
import static utils.PrintUtil.printnb;

interface Counter {
    int next();
}

public class LocalInnerClass {
    private int count = 0;

    public static void main(String[] args) {
        LocalInnerClass lic = new LocalInnerClass();
        Counter c1 = lic.getCounter("Local inner ");
        Counter c2 = lic.getCounter2("Anonymous inner ");
        for (int i = 0; i < 5; ++i) {
            println(c1.next());
        }
        for (int i = 0; i < 5; ++i) {
            println(c2.next());
        }
    }

    Counter getCounter(final String name) {
        // A local inner class:
        // A local inner class cannot have an access specifier because it isn’t part of the outer class,
        // but it does have access to the final variables in the current code block and all the members of the enclosing class
        class LocalCounter implements Counter {
            public LocalCounter() {
                // Local inner class can have a constructor
                println("LocalCounter()");
            }

            @Override
            public int next() {
                printnb(name); // Access local final
                return count++;
            }
        }
        return new LocalCounter();
    }

    // The same thing with an anonymous inner class:
    Counter getCounter2(final String name) {
        return new Counter() {
            {
                println("Counter()");
            }

            @Override
            public int next() {
                printnb(name); // Access local final
                return count++;
            }
        };
    }
}