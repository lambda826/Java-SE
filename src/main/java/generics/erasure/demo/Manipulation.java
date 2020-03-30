package generics.erasure.demo;


public class Manipulation {
    static class Manipulator<T> {
        private T obj;

        public Manipulator(T x) {
            obj = x;
        }

        // Error: cannot find symbol: method f():
        public void manipulate() {
            //            obj.f();
        }
    }


    public static void main(String[] args) {
        HasF hf = new HasF();
        Manipulator<HasF> manipulator = new Manipulator<>(hf);
        manipulator.manipulate();
    }
}