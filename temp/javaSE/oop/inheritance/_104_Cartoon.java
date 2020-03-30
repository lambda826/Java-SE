package oop.inheritance;

import static common.utils.PrintUtil.println;

class Art {
    Art() {
        println("Art constructor");
    }
}

class Drawing extends Art {
    Drawing() {
        println("Drawing constructor");
    }
}

public class _104_Cartoon extends Drawing {

    public _104_Cartoon() {
        println("Cartoon constructor");
    }

    public static void main(String[] args) {
        _104_Cartoon x = new _104_Cartoon();
    }
}