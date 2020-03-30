package lambda.behavior_parameterization;


import common.pojos.Color;
import common.pojos.fruit.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Predicate;

import static common.utils.PrintUtil.println;
import static lambda.Constant.inventory;


public class BehaviorParameterizationDemo {

    public static List<Apple> filterByApplePredicate(List<Apple> inventory, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void prettyPrintApple(List<Apple> inventory, ApplePrinter Printer) {
        for (Apple apple : inventory) {
            String output = Printer.accept(apple);
            println(output);
        }
    }

    public static <T> List<T> filterGenerics(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (predicate.test(e)) {
                result.add(e);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Behavior parameterization
        filterByApplePredicate(inventory, new ApplePredicateImpl.AppleColorPredicate());
        filterByApplePredicate(inventory, new ApplePredicateImpl.AppleWeightPredicate());
        filterByApplePredicate(inventory, new ApplePredicateImpl.AppleRedAndHeavyPredicate());
        // Behavior parameterization
        prettyPrintApple(inventory, new ApplePrinterImpl.AppleSimplePrinter());
        prettyPrintApple(inventory, new ApplePrinterImpl.AppleFancyPrinter());

        // Lambda expression
        println(filterByApplePredicate(inventory, apple -> apple.getColor().equals(Color.RED)));

        // Generic type
        println(filterGenerics(Arrays.asList(1, 3, 6, 8), (Integer i) -> i % 2 == 0));

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Other examples
        // Sorting with a comparator
        inventory.sort(new Comparator<Apple>() {
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight() - a2.getWeight();
            }
        });
        inventory.sort((Apple a1, Apple a2) -> a1.getWeight() - a2.getWeight());

        // Executing a block of code with Runnable
        Thread t = new Thread(new Runnable() {
            public void run() {
                System.out.println("Hello world");
            }
        });
        t = new Thread(() -> System.out.println("Hello world"));
        t.run();

        // Returning a result using Callable
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> threadName = executorService.submit(new Callable<String>() {
            public String call() throws Exception {
                return Thread.currentThread().getName();
            }
        });
        threadName = executorService.submit(() -> Thread.currentThread().getName());
        try {
            threadName.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
