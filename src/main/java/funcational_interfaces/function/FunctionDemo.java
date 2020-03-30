package interfaces.funcational_interfaces.function;


import java.util.function.Function;

import static common.utils.PrintUtil.println;

/**
 * @FunctionalInterface public interface Function<T, ​R>
 * Represents a function that accepts one argument and produces a result
 * This is a functional interface whose functional method is apply(Object)
 */
public class FunctionDemo<T, R> {

    /**
     * R apply​(T t), T -> R
     */
    public static void apply() {
        Function<String, Integer> function = (str) -> Integer.parseInt(str); // String -> Integer
        int result = function.apply("0826");
        println(result);
    }

    /**
     * default <V> Function<T,​ V> andThen​(Function<? super R,​ ? extends V> after)
     */
    public static void andThen() {
        Function<String, String> f1 = x -> x.toLowerCase();
        Function<String, String> f2 = x -> x.toUpperCase();
        Function<String, String> f3 = f1.andThen(f2);
        Function<String, String> f4 = f1.andThen(x -> x.toUpperCase());
        Function<String, String> f5 = f1.andThen(String::toUpperCase);
        println(f3.apply("1"));
        println(f4.apply("1"));
        println(f5.apply("1"));
    }

    /**
     *     default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
     *         Objects.requireNonNull(before);
     *         return (V v) -> apply(before.apply(v));
     *     }
     */
    public static void compose() {
        Function<String, String> f1 = x -> String.valueOf(x); // Integer -> String
        Function<String, String> f2 = x -> String.valueOf(x); // String -> Double
        Function<String, String> f3 = f1.compose(f2);
        //        Function<Integer, String> f4 = f1.compose(x -> Integer.parseInt(x));
        //        Function<String, String> f5 = f1.compose(String::toUpperCase);
        //        println(f3.apply("1"));
        //        println(f4.apply("1"));
        //        println(f5.apply("1"));
    }


    /**
     * static <T> Function<T,​T> identity()
     */
    public static void identity() {

    }


    public static void main(String[] args) {
        andThen();
    }

}
