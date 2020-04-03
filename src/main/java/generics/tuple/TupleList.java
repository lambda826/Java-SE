package generics.tuple;

import generics.tuple.TupleTest.Amphibian;
import generics.tuple.TupleTest.Vehicle;

import java.util.ArrayList;

import static utils.PrintUtil.println;

public class TupleList<A, B, C, D> extends ArrayList<Tuple4<A, B, C, D>> {

    public static void main(String[] args) {
        TupleList<Vehicle, Amphibian, String, Integer> tl = new TupleList<>();
        tl.add(TupleTest.h());
        tl.add(TupleTest.h());
        for (Tuple4<Vehicle, Amphibian, String, Integer> i : tl) {
            println(i);
        }
    }
}