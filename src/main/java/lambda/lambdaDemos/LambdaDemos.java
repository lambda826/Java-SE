package lambda.lambdaDemos;


import common.exception.EmptyArrayException;
import common.pojos.Color;
import common.pojos.fruit.Apple;
import interfaces.funcational_interfaces.funtionalInterfaces.DoubleNumberArrayFunc;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparingInt;
import static lambda.Constant.inventory;
import static lambda.behavior_parameterization.BehaviorParameterizationDemo.filterByApplePredicate;
import static utils.PrintUtil.println;


public class LambdaDemos {

    public static void lambdaDemos() {
        // Example 1: () -> void
        Runnable r = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            println("Hello!");
        };
        Thread t = new Thread(r);
        t.start();

        // Example 2: Passing lambda as argument, (Apple) -> boolean
        println(filterByApplePredicate(inventory, (Apple a) -> Color.GREEN.equals(a.getColor())));

        // Example 3: (T, T) -> int
        inventory.sort(comparingInt(Apple::getWeight));

        // Example 4: Lambda w/ exception
        double[] values = { 1.0, 2.0 };
        DoubleNumberArrayFunc average = (n) -> {
            double sum = 0;
            if (n.length == 0) {
                throw new EmptyArrayException();
            }
            for (int i = 0; i < n.length; i++) {
                sum += n[i];
            }
            return sum / n.length;
        };
        //        System.out.println(average.func(values));
        //        System.out.println(average.func(new double[0]));
    }

    public static void collectionsSort(List<String> words) {
        // Anonymous class instance as a function object - obsolete!
        Collections.sort(words, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });
        // Lambda expression as function object (replaces anonymous class)
        Collections.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        Collections.sort(words, comparingInt(String::length));
        words.sort(comparingInt(String::length));
    }

    public static void main(String... args) {
        lambdaDemos();
    }

}