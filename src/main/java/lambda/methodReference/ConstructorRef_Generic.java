package lambda.methodReference;

import java.util.function.Function;
import java.util.function.Supplier;

class ConstructorRef_Generic {

    static class MyClass<T> {
        private T val;

        MyClass() {
            val = null;
        }

        MyClass(T v) {
            val = v;
        }
    }

    public static void main(String[] args) {
        Function<Integer, MyClass> func = MyClass::new;
        Supplier<MyClass> supplier = MyClass::new;
        MyClass<Integer> mc = func.apply(100);
        mc = supplier.get();
    }
}