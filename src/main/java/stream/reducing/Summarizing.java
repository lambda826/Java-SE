package stream.reducing;

import common.pojos.Dish;

import java.util.Comparator;

import static common.pojos.Dish.menu;
import static utils.PrintUtil.println;
import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.summingInt;

public class Summarizing {

    public static void main(String... args) {
        println(menu.stream().collect(counting()));
        println(menu.stream().collect(summingInt(Dish::getCalories)));
        println(menu.stream().collect(averagingInt(Dish::getCalories)));
        println(menu.stream().collect(summarizingInt(Dish::getCalories)));
        println(menu.stream().collect(maxBy(Comparator.comparingInt(Dish::getCalories))).get());
    }
}
