package innerClazz.memberInnerClass.namespace;

import static utils.PrintUtil.println;

class Egg2 {
    private Yolk y = new Yolk();

    public Egg2() {
        println("New Egg2()"); // 2
    }

    public void insertYolk(Yolk yy) {
        y = yy;
    }

    public void g() {
        y.f();
    }

    protected class Yolk {
        public Yolk() {
            println("Egg2.Yolk()"); // 1, 3
        }

        public void f() {
            println("Egg2.Yolk.f()");
        }
    }
}

public class DifferentNameSpace extends Egg2 {

    public DifferentNameSpace() {
        insertYolk(new Yolk());
    }

    public static void main(String[] args) {
        Egg2 e2 = new DifferentNameSpace();
        e2.g();
    }

    public class Yolk extends Egg2.Yolk {
        public Yolk() {
            println("BigEgg2.Yolk()"); // 4
        }

        public void f() {
            println("BigEgg2.Yolk.f()"); // 5
        }
    }

}