package innerClazz.memberInnerClass;

class O {
    private void f() {
    }

    class P {
        private void g() {
        }

        public class Q {
            void h() {
                g(); // O::f()
                f(); // P::g()
            }
        }
    }
}

public class MultiNestingAccess {
    public static void main(String[] args) {
        O o = new O();
        O.P op = o.new P();
        O.P.Q opq = op.new Q();
        opq.h();
    }
}
