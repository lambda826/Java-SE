package generics.bounds.wildcards;

import generics.bounds.wildcards._01_CovariantArrays.Apple;
import generics.bounds.wildcards._01_CovariantArrays.Fruit;
import generics.bounds.wildcards._01_CovariantArrays.Orange;

import static common.utils.PrintUtil.println;

public class _05_Holder<T> {
    private T value;

    public _05_Holder() {
    }

    public _05_Holder(T val) {
        value = val;
    }

    public void set(T val) {
        value = val;
    }

    public T get() {
        return value;
    }

    public boolean equals(Object obj) {
        return value.equals(obj);
    }

    public static void main(String[] args) {
        _05_Holder<Apple> Apple = new _05_Holder<>(new Apple());
        Apple d = Apple.get();
        Apple.set(d);

        // Cannot upcast
        // _05_Holder<Fruit> Fruit = Apple;

        // OK
        // If you create a _05_Holder<Apple>, you cannot upcast it to a _05_Holder<Fruit>, but you can upcast to a _05_Holder<? extends Fruit>
        _05_Holder<? extends Fruit> fruit = Apple;
        Fruit p = fruit.get();
        // Returns 'Object'
        d = (Apple) fruit.get();
        try {
            Orange c = (Orange) fruit.get(); // No warning
        } catch (Exception e) {
            println(e);
        }
        // Cannot call set()
        // fruit.set(new Apple()); 

        // Cannot call set()
        // fruit.set(new Fruit());

        // OK
        println(fruit.equals(d));
    }
}