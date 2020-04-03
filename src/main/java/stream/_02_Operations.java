package stream;

import common.pojos.Dish;
import utils.PrintUtil;

import java.util.Arrays;
import java.util.List;

import static common.pojos.Dish.menu;
import static common.pojos.Dish.specialMenu;
import static java.util.stream.Collectors.toList;

public class _02_Operations {

    public static void main(String[] args) {
        filtering();
        distinct();
        limiting();
        skipping();
        mapping();
        flatMapping();
        matching();
        finding();
        reducing();
        takeWhile();
        dropWhile();
    }

    public static void filtering() {
        menu.stream().filter(Dish::isVegetarian).collect(toList()).forEach(PrintUtil::println);
    }

    public static void distinct() {
        Arrays.asList(1, 2, 1, 3, 3, 2, 4).stream().filter(i -> i % 2 == 0).distinct().forEach(PrintUtil::println);
    }

    public static void limiting() {
        menu.stream().filter(d -> d.getCalories() > 300).limit(3).collect(toList()).forEach(PrintUtil::println);
    }

    public static void skipping() {
        menu.stream().filter(d -> d.getCalories() > 300).skip(2).collect(toList()).forEach(PrintUtil::println);
    }

    public static void mapping() {
        menu.stream().map(Dish::getName).collect(toList()).forEach(PrintUtil::println);
        Arrays.asList("Modern", "Java", "In", "Action").stream()
              .map(String::length)
              .forEach(PrintUtil::println);

        menu.stream()
            .map(Dish::getName)
            .map(String::length)
            .forEach(PrintUtil::println);
    }

    public static void flatMapping() {
        Arrays.asList("Hello", "World").stream()
              .flatMap((String line) -> Arrays.stream(line.split("")))
              .distinct()
              .forEach(PrintUtil::println);

        Arrays.asList("Hello", "World").stream()
              .map(word -> word.split("")).
                                                  flatMap(Arrays::stream)
              .distinct()
              .forEach(PrintUtil::println);

        Arrays.asList(1, 2, 3, 4, 5).stream()
              .flatMap((Integer i) -> Arrays.asList(6, 7, 8).stream().map((Integer j) -> new int[] { i, j }))
              .filter(pair -> (pair[0] + pair[1]) % 3 == 0)
              .collect(toList())
              .forEach(pair -> System.out.println("(" + pair[0] + ", " + pair[1] + ")"));
    }

    public static void matching() {
        menu.stream().anyMatch(Dish::isVegetarian);
        menu.stream().allMatch(d -> d.getCalories() < 1000);
        menu.stream().noneMatch(d -> d.getCalories() >= 1000);
    }

    public static void finding() {
        menu.stream().filter(Dish::isVegetarian).findAny().ifPresent(d -> System.out.println(d.getName()));
        System.out.println(Arrays.asList(1, 2, 3, 4, 5).stream().map(n -> n * n).filter(n -> n % 3 == 0).findFirst().get());
    }

    public static void reducing() {
        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);
        numbers.stream().reduce(0, (a, b) -> a + b);
        numbers.stream().reduce(0, Integer::sum);
        numbers.stream().reduce(0, (a, b) -> Integer.max(a, b));
        numbers.stream().reduce(Integer::min).ifPresent(PrintUtil::println); // No initial value, return Optional<T>
        menu.stream().map(Dish::getCalories).reduce(0, Integer::sum);
        menu.stream().count();
    }

    // Slicing JDK 9+
    // TakeWhile: stops once it has found an element that fails to match
    public static void takeWhile() {
        specialMenu.stream().takeWhile(dish -> dish.getCalories() < 320).collect(toList()).forEach(PrintUtil::println);
    }

    // Slicing JDK 9+
    // DropWhile: throws away the elements at the start where the predicate is false
    public static void dropWhile() {
        specialMenu.stream().dropWhile(dish -> dish.getCalories() < 320).collect(toList()).forEach(PrintUtil::println);
    }

}
