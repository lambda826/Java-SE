package generics.erasure;

import java.util.ArrayList;

import static utils.PrintUtil.println;

public class ErasedTypeEquivalence {
    public static void main(String[] args) {
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        println(c1 == c2);
        println(c1);
        println(c2);
    }
}