package generics.erasure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static common.utils.PrintUtil.println;


/*
 * According to the JDK documentation, Class.getTypeParameters() "returns an array of TypeVariable objects that represent the type variables declared by the generic declaration..."
 * This seems to suggest that you might be able to find out what the parameter types are.
 * However, as you can see from the output, all you find out is the identifiers that are used as the parameter placeholders, which is not such an interesting piece of information.
 * The cold truth is: There’s no information about generic parameter types available inside generic code
 */
public class LostInformation {
    static class Frob {
    }

    static class Fnorkle {
    }

    static class Quark<Q> {
    }

    static class Particle<POSITION, MOMENTUM> {
    }


    public static void main(String[] args) {
        List<Frob> list = new ArrayList<>();
        Map<Frob, Fnorkle> map = new HashMap<>();
        Quark<Fnorkle> quark = new Quark<>();
        Particle<Long, Double> p = new Particle<>();

        println(Arrays.toString(list.getClass().getTypeParameters()));
        println(Arrays.toString(map.getClass().getTypeParameters()));
        println(Arrays.toString(quark.getClass().getTypeParameters()));
        println(Arrays.toString(p.getClass().getTypeParameters()));
    }
}