package clazz;

import static utils.PrintUtil.println;

/*

Initialization order:
Load derived class -> load base class
Initialize base class static fields -> Initialize derived class static fields
Load derived class constructor -> load base class constructor
Initialize base class fields -> excute base class constructor
Initialize derived class fileds -> excute Derived class constructor

*/
class Bowl {
    Bowl(int marker) {
        println("Bowl(" + marker + ")");
    }

    void f1(int marker) {
        println("f1(" + marker + ")");
    }
}

class Table {
    static Bowl bowl1 = new Bowl(1);

    Table() {
        println("Table()");
        bowl2.f1(1);
    }

    void f2(int marker) {
        println("f2(" + marker + ")");
    }

    static Bowl bowl2 = new Bowl(2);
}

class Cupboard {
    Bowl bowl3 = new Bowl(3);
    static Bowl bowl4 = new Bowl(4);

    Cupboard() {
        println("Cupboard()");
        bowl4.f1(2);
    }

    void f3(int marker) {
        println("f3(" + marker + ")");
    }

    static Bowl bowl5 = new Bowl(5);
}

public class _103_StaticInitialization {

    static Table table = new Table();
    static Cupboard cupboard = new Cupboard();

    public static void main(String[] args) {
        println("Creating new Cupboard() in main");
        new Cupboard();
        println("Creating new Cupboard() in main");
        new Cupboard();
        table.f2(1);
        cupboard.f3(1);
    }

}