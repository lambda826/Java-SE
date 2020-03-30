package clazz;

import static common.utils.PrintUtil.println;

class Cup {
    Cup(int marker) {
        println("Cup(" + marker + ")");
    }

    void f(int marker) {
        println("f(" + marker + ")");
    }
}

class Cups {
    static Cup cup1;
    static Cup cup2;

    static {
        cup1 = new Cup(1);
        cup2 = new Cup(2);
    }

    Cups() {
        println("Cups()");
    }
}

public class _104_ExplicitStatic {
    public static void main(String[] args) {
        println("Inside main()");
        Cups.cup1.f(99);
    }
}