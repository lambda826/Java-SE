package reflection;

import reflection.interfaca.A;

import static utils.PrintUtil.println;

class InnerA {
    private static class C implements A {
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

    public static A makeA() {
        return new C();
    }
}

public class InnerImplementation {
    public static void main(String[] args) throws Exception {
        A a = InnerA.makeA();
        a.f();
        System.out.println(a.getClass().getName());
        // Reflection still gets into the private class:
        HiddenImplementation.callHiddenMethod(a, "g");
        HiddenImplementation.callHiddenMethod(a, "u");
        HiddenImplementation.callHiddenMethod(a, "v");
        HiddenImplementation.callHiddenMethod(a, "w");
    }
} /* Output:
  public C.f()
  InnerA$C
  public C.g()
  package C.u()
  protected C.v()
  private C.w()
  *///:~
