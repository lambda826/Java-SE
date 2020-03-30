package generics.tuple;

import static common.utils.PrintUtil.println;


public class TupleTest {
    static class Amphibian {

    }

    static class Vehicle {

    }

    public static Tuple2<String, Integer> f() {
        return new Tuple2<>("hi", 47);
    }

    public static Tuple3<Amphibian, String, Integer> g() {
        return new Tuple3<>(new Amphibian(), "hi", 47);
    }

    public static Tuple4<Vehicle, Amphibian, String, Integer> h() {
        return new Tuple4<>(new Vehicle(), new Amphibian(), "hi", 47);
    }

    public static Tuple5<Vehicle, Amphibian, String, Integer, Double> k() {
        return new Tuple5<>(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
    }

    public static void main(String[] args) {
        Tuple2<String, Integer> ttsi = f();
        println(ttsi);
        println(g());
        println(h());
        println(k());
    }
}