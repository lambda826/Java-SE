package interfaces.funcational_interfaces.function;

import java.util.function.BiFunction;

/**
 * @FunctionalInterface public interface BiFunction<T,​ U,​ R>
 * Represents a function that accepts two arguments and produces a result. This is the two-arity specialization of Function
 * This is a functional interface whose functional method is apply(Object, Object)
 */
public class BiFunctionDemo {

    /**
     * R apply​(T t, U u)
     */
    public static void applyDemo() {
        BiFunction<Integer, Integer, Integer> function = (a, b) -> a + b;
        Integer result = function.apply(12, 13);
        System.out.println(result);
    }

    /**
     * default <V> BiFunction<T,​U,​V> andThen​(Function<? super R,​? extends V> after)
     */
    public static void andThenMethod() {

    }

}
