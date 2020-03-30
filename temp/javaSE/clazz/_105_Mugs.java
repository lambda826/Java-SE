package clazz;

import static common.utils.PrintUtil.println;

class Mug {
    Mug(int marker) {
        println("Mug(" + marker + ")");
    }

    void f(int marker) {
        println("f(" + marker + ")");
    }
}

public class _105_Mugs {
    Mug mug1;
    Mug mug2;

    {
        mug1 = new Mug(1);
        mug2 = new Mug(2);
        println("mug1 & mug2 initialized");
    }

    _105_Mugs() {
        println("Mugs()");
    }

    _105_Mugs(int i) {
        println("Mugs(int)");
    }

    public static void main(String[] args) {
        println("Inside main()");
        new _105_Mugs();
        println("new Mugs() completed");
        new _105_Mugs(1);
        println("new Mugs(1) completed");
    }
}