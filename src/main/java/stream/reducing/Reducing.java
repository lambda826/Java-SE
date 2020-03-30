package stream.reducing;

import common.pojos.Dish;

import java.util.Comparator;
import java.util.function.BinaryOperator;

import static common.pojos.Dish.menu;
import static java.util.stream.Collectors.reducing;

public class Reducing {
    public static void main(String[] args) {

    }


    private static Dish findMostCaloricDish() {
        return menu.stream().collect(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2)).get();
    }

    private static Dish findMostCaloricDishUsingComparator() {
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        BinaryOperator<Dish> moreCaloricOf = BinaryOperator.maxBy(dishCaloriesComparator);
        return menu.stream().collect(reducing(moreCaloricOf)).get();
    }
}
