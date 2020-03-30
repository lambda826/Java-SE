package lambda.methodReference;

import java.util.function.Function;
import java.util.function.Supplier;

class ConstructorRef {

    static class MyClass {
        private int val;

        MyClass() {
            val = 0;
        }

        MyClass(int v) {
            val = v;
        }
    }

    public static void main(String[] args) {
        Function<Integer, MyClass> func = MyClass::new;
        Supplier<MyClass> supplier = MyClass::new;
        MyClass mc = func.apply(100);
        mc = supplier.get();
    }
}