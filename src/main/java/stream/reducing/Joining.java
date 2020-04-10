package stream.reducing;

import common.pojos.Dish;

import static common.pojos.Dish.menu;
import static java.util.stream.Collectors.joining;
import static utils.PrintUtil.println;

public class Joining {
    public static void main(String[] args) {
        println(menu.stream().map(Dish::getName).collect(joining()));
        println(menu.stream().map(Dish::getName).collect(joining(", ")));
        println(menu.stream().map(Dish::getName).collect(joining(", ", "[", "]")));
    }
}
