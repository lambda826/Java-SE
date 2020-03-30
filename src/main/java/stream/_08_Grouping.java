package stream;

import common.enums.CaloricLevel;
import common.pojos.Dish;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static common.pojos.Dish.dishTags;
import static common.pojos.Dish.menu;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.flatMapping;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;


public class _08_Grouping {

    public static void main(String... args) {

        // groupingBy
        // static <T, K> Collector<T, ?, Map<K, List<T>>> groupingBy(Function<? super T, ? extends K> classifier)
        Map<Dish.Type, List<Dish>> groupDishesByType = menu.stream().collect(groupingBy(Dish::getType));

        Map<CaloricLevel, List<Dish>> groupDishesByCaloricLevel = menu.stream().collect(groupingBy(dish -> {
            if (dish.getCalories() <= 400) {
                return CaloricLevel.DIET;
            } else if (dish.getCalories() <= 700) {
                return CaloricLevel.NORMAL;
            } else {
                return CaloricLevel.FAT;
            }
        }));

        // filtering
        // static <T, A, R> Collector<T, ?, R> filtering(Predicate<? super T> predicate, Collector<? super T, A, R> downstream)
        Map<Dish.Type, List<Dish>> groupCaloricDishesByType = menu.stream().collect(groupingBy(Dish::getType, filtering(_00_Dish -> _00_Dish.getCalories() > 500, toList())));

        // mapping
        // static <T, U, A, R> Collector<T, ?, R> mapping(Function<? super T, ? extends U> mapper, Collector<? super U, A, R> downstream)
        Map<Dish.Type, List<String>> groupDishNamesByType = menu.stream().collect(groupingBy(Dish::getType, mapping(Dish::getName, toList())));

        // flatMapping
        // static <T, U, A, R> Collector<T, ?, R> flatMapping(Function<? super T, ? extends Stream<? extends U>> mapper, Collector<? super U, A, R> downstream)
        Map<Dish.Type, Set<String>> groupDishTagsByType = menu.stream().collect(groupingBy(Dish::getType, flatMapping(_00_Dish -> dishTags.get(_00_Dish.getName()).stream(), toSet())));

        // Multilevel grouping
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> groupDishedByTypeAndCaloricLevel = menu.stream().collect(groupingBy(Dish::getType, groupingBy(dish -> {
            if (dish.getCalories() <= 400) {
                return CaloricLevel.DIET;
            } else if (dish.getCalories() <= 700) {
                return CaloricLevel.NORMAL;
            } else {
                return CaloricLevel.FAT;
            }
        })));


        // Collecting data in subgroups
        // counting
        // static <T> Collector<T, ?, Long> counting()
        Map<Dish.Type, Long> countDishesInGroups = menu.stream().collect(groupingBy(Dish::getType, counting()));

        // maxBy
        // static <T> Collector<T, ?, Optional<T>> maxBy(Comparator<? super T> comparator)
        Map<Dish.Type, Optional<Dish>> mostCaloricByType = menu.stream().collect(groupingBy(Dish::getType, maxBy(Comparator.comparingInt(Dish::getCalories))));

        // collectingAndThen
        // static <T, A, R, RR> Collector<T, A, RR> collectingAndThen(Collector<T, A, R> downstream, Function<R, RR> finisher)
        Map<Dish.Type, Dish> mostCaloricByType2 = menu.stream().collect(groupingBy(Dish::getType, collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));

        // static <T> Collector<T, ?, Optional<T>> reducing(BinaryOperator<T> op)
        Map<Dish.Type, Optional<Dish>> mostCaloricDishesByType = menu.stream().collect(groupingBy(Dish::getType, reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2)));

        // static <T, A, R, RR> Collector<T, A, RR> collectingAndThen(Collector<T, A, R> downstream, Function<R, RR> finisher)
        Map<Dish.Type, Dish> mostCaloricDishesByTypeWithoutOptionalsMap = menu.stream().collect(groupingBy(Dish::getType, collectingAndThen(reducing((d1, d2) -> d1.getCalories() > d2.getCalories()
                                                                                                                                                                         ? d1 : d2), Optional::get)));
        // static <T> Collector<T, ?, Integer> summingInt(ToIntFunction<? super T> mapper)
        Map<Dish.Type, Integer> sumCaloriesByType = menu.stream().collect(groupingBy(Dish::getType, summingInt(Dish::getCalories)));

        // static <T, U, A, R> Collector<T, ?, R> mapping(Function<? super T, ? extends U> mapper, Collector<? super U, A, R> downstream)
        Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByTyp = menu.stream().collect(groupingBy(Dish::getType, mapping(dish -> {
            if (dish.getCalories() <= 400) {
                return CaloricLevel.DIET;
            } else if (dish.getCalories() <= 700) {
                return CaloricLevel.NORMAL;
            } else {
                return CaloricLevel.FAT;
            }
        }, toSet())));

        Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType = menu.stream().collect(groupingBy(Dish::getType, mapping(dish -> {
            if (dish.getCalories() <= 400) {
                return CaloricLevel.DIET;
            } else if (dish.getCalories() <= 700) {
                return CaloricLevel.NORMAL;
            } else {
                return CaloricLevel.FAT;
            }
        }, toCollection(HashSet::new))));
    }
}
