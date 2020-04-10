package stream;

import common.pojos.Dish;

import java.util.Comparator;
import java.util.function.BinaryOperator;

import static common.pojos.Dish.menu;
import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.summingInt;
import static utils.PrintUtil.println;

public class _07_Reducing {

    public static void main(String... args) {


        // statistics
        println("Total calories in menu: " + menu.stream().collect(summingInt(Dish::getCalories)));
        println("Average calories in menu: " + menu.stream().collect(averagingInt(Dish::getCalories)));
        println("Menu statistics: " + menu.stream().collect(summarizingInt(Dish::getCalories)));

        // joining
        println("Short menu: " + menu.stream().map(Dish::getName).collect(joining()));
        println("Short menu comma separated: " + menu.stream().map(Dish::getName).collect(joining(", ")));

        // reducing
        println("Total calories in menu: " + menu.stream().collect(reducing(0, Dish::getCalories, (i, j) -> i + j)));
        println("Total calories in menu: " + menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum)));

        println("Total calories in menu: " + menu.stream().map(Dish::getCalories).reduce(Integer::sum).get());
        println("Total calories in menu: " + menu.stream().mapToInt(Dish::getCalories).sum());

        println("The most caloric dish is: " + menu.stream().collect(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2)).get());
        println("The most caloric dish is: " + menu.stream().collect(reducing(BinaryOperator.maxBy(Comparator.comparingInt(Dish::getCalories)))).get());
    }

}
