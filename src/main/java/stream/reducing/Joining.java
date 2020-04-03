package stream.reducing;

import common.pojos.Dish;

import static common.pojos.Dish.menu;
import static utils.PrintUtil.println;
import static java.util.stream.Collectors.joining;

public class Joining {
    public static void main(String[] args) {
        println(menu.stream().map(Dish::getName).collect(joining()));
        println(menu.stream().map(Dish::getName).collect(joining(", ")));
        println(menu.stream().map(Dish::getName).collect(joining(", ", "[", "]")));
    }
}
