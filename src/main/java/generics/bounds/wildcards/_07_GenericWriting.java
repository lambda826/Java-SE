package generics.bounds.wildcards;

import generics.bounds.wildcards._01_CovariantArrays.Apple;
import generics.bounds.wildcards._01_CovariantArrays.Fruit;

import java.util.ArrayList;
import java.util.List;

public class _07_GenericWriting {

    static List<Apple> apples = new ArrayList<>();
    static List<Fruit> fruit = new ArrayList<>();

    static <T> void writeExact(List<T> list, T item) {
        list.add(item);
    }

    static <T> void writeWithWildcard(List<? super T> list, T item) {
        list.add(item);
    }

    static void f1() {
        writeExact(apples, new Apple());
        writeExact(fruit, new Apple());
    }

    static void f2() {
        writeWithWildcard(apples, new Apple());
        writeWithWildcard(fruit, new Apple());
    }

}
