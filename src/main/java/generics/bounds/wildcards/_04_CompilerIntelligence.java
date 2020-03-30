package generics.bounds.wildcards;

import generics.bounds.wildcards._01_CovariantArrays.Apple;
import generics.bounds.wildcards._01_CovariantArrays.Fruit;

import java.util.Arrays;
import java.util.List;

public class _04_CompilerIntelligence {
    public static void main(String[] args) {
        List<? extends Fruit> flist = Arrays.asList(new Apple());
        Apple a = (Apple) flist.get(0);
        // Argument is 'Object'
        flist.contains(new Apple());
        // Argument is 'Object'
        flist.indexOf(new Apple());
    }
}
