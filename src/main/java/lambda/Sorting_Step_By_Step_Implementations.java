package lambda;

import common.pojos.Color;
import common.pojos.fruit.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class Sorting_Step_By_Step_Implementations {

    static class AppleComparator implements Comparator<Apple> {
        @Override
        public int compare(Apple a1, Apple a2) {
            return a1.getWeight() - a2.getWeight();
        }
    }

    public static void main(String... args) {

        List<Apple> inventory = new ArrayList<>();
        inventory.addAll(Arrays.asList(new Apple(80, Color.GREEN), new Apple(155, Color.GREEN), new Apple(120, Color.RED)));

        // 1 Pass code
        inventory.sort(new AppleComparator());

        // 2 Anonymous class
        inventory.sort(new Comparator<Apple>() {
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight() - a2.getWeight();
            }
        });

        // 3 Lambda expression
        inventory.sort((a1, a2) -> a1.getWeight() - a2.getWeight());
        inventory.sort(Comparator.comparing(a -> a.getWeight()));

        // 4 Method reference
        inventory.sort(Comparator.comparing(Apple::getWeight));
    }
}

