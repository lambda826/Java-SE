package generics;

import java.util.ArrayList;
import java.util.List;

import static common.utils.PrintUtil.println;

public class GenericVarargs {

    public static <T> List<T> makeList(T... args) {
        List<T> result = new ArrayList<>();
        for (T item : args) {
            result.add(item);
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> ls = makeList("A");
        println(ls);
        ls = makeList("A", "B", "C");
        println(ls);
        ls = makeList("ABCDEFFHIJKLMNOPQRSTUVWXYZ".split(""));
        println(ls);
    }
}