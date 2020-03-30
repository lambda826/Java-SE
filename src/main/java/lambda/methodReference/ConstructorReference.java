package lambda.methodReference;

import common.pojos.Color;
import common.pojos.fruit.Apple;
import common.pojos.fruit.Fruit;
import common.pojos.fruit.Orange;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.util.stream.Collectors.toList;

public class ConstructorReference {

    static Map<String, Function<Integer, Fruit>> map = new HashMap<>() {{
        map.put("apple", Apple::new); // Function: Integer -> Fruit
        map.put("orange", Orange::new); // Function: Integer -> Fruit
    }};

    public static Fruit giveMeApple(String fruitName, Integer weight) {
        return map.get(fruitName).apply(weight);
    }

    public static void main(String[] args) {
        Apple apple;
        Supplier<Apple> s = Apple::new; // Default constructor
        s = () -> new Apple(); // Default constructor
        apple = s.get();

        Function<Integer, Apple> f = Apple::new; // Constructor with 1 argument
        f = (weight) -> new Apple(weight); // Constructor with 1 argument
        apple = f.apply(100);

        // Passing a constructor reference to the map method
        List<Integer> weights = Arrays.asList(7, 3, 5, 10);
        List<Apple> apples = weights.stream().map(Apple::new).collect(toList());

        BiFunction<Integer, Color, Apple> biFunction = Apple::new;
        biFunction = (weight, color) -> new Apple(weight, color);
        apple = biFunction.apply(100, Color.GREEN);
    }

}
