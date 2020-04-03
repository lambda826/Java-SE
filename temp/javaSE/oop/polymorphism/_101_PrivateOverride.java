package oop.polymorphism;

import static utils.PrintUtil.println;

public class _101_PrivateOverride {

    // a private method is automatically final,
    private void f() {
        println("private f()");
    }

    public static void main(String[] args) {
        _101_PrivateOverride po = new Derived();
        po.f();
    }

}

class Derived extends _101_PrivateOverride {

    public void f() {
        println("public f()");
    }

}