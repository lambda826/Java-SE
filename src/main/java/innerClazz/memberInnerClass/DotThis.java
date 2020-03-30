package innerClazz.memberInnerClass;

import static common.utils.PrintUtil.println;

// Qualifying access to the outer-class object
public class DotThis {
    public static void main(String[] args) {
        DotThis dt = new DotThis();
        DotThis.Inner dti = dt.inner();
        dti.outer().f();
    }

    public Inner inner() {
        return new Inner();
    }

    void f() {
        println("DotThis.f()");
    }

    public class Inner {
        public DotThis outer() {
            // A plain "this" would be Inner's "this"
            return DotThis.this;

        }
    }
}