package reflection.packageAccess;

import reflection.interfaca.A;

import static common.utils.PrintUtil.println;

class C implements A {
    public void f() {
        println("public C.f()");
    }

    public void g() {
        println("public C.g()");
    }

    void u() {
        println("package C.u()");
    }

    protected void v() {
        println("protected C.v()");
    }

    private void w() {
        println("private C.w()");
    }
}

public class HiddenC {
    public static A makeA() {
        return new C();
    }
}
