package stream;

import common.pojos.Dish;
import utils.PrintUtil;

import java.util.Arrays;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class _01_Streams {

    public static void main(String... args) {

        // Low Caloric Dishes Name
        Dish.menu.parallelStream().filter(Dish::isLowCalory).sorted(comparing(Dish::getCalories)).map(Dish::getName).collect(toList()).forEach(PrintUtil::println);

        // Three High Caloric Dish Names
        Dish.menu.stream().filter(dish -> dish.getCalories() > 300).map(Dish::getName).limit(3).collect(toList()).forEach(PrintUtil::println);

        // A stream can be traversed only once
        Stream<String> s = Arrays.asList("Modern", "Java", "In", "Action").stream();
        s.forEach(PrintUtil::println);
        // java.lang.IllegalStateException: stream has already been operated upon or closed
        // s.forEach(PrintUtil::println);

        // Intermediate operations can usually be merged and processed into a single pass by the terminal operation
        // Laziness1
        Dish.menu.stream().filter(dish -> {
            System.out.println("filtering:" + dish.getName());
            return dish.getCalories() > 300;
        }).map(dish -> {
            System.out.println("mapping:" + dish.getName());
            return dish.getName();
        }).limit(3).collect(toList());

        // Laziness2
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8).stream().filter(n -> {
            System.out.println("filtering " + n);
            return n % 2 == 0;
        }).map(n -> {
            System.out.println("mapping " + n);
            return n * n;
        }).limit(2).collect(toList()).forEach(PrintUtil::println);
    }

}
