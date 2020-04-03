package oop.inheritance;

import static utils.PrintUtil.println;

class WithFinals {

    // Identical to "private" alone:
    private final void f() {
        println("WithFinals.f()");
    }

    // Also automatically "final":
    private void g() {
        println("WithFinals.g()");
    }

}

class OverridingPrivate extends WithFinals {

    private final void f() {
        println("OverridingPrivate.f()");
    }

    private void g() {
        println("OverridingPrivate.g()");
    }

}

class OverridingPrivate2 extends OverridingPrivate {

    public final void f() {
        println("OverridingPrivate2.f()");
    }

    public void g() {
        println("OverridingPrivate2.g()");
    }

}

public class _118_FinalOverridingIllusion {

    public static void main(String[] args) {
        OverridingPrivate2 op2 = new OverridingPrivate2();
        op2.f();
        op2.g();
        // You can upcast:
        OverridingPrivate op = op2;
        // But you can't call the methods:
        //! op.f();
        //! op.g();
        // Same here:
        WithFinals wf = op2;
        //! wf.f();
        //! wf.g();
    }

}