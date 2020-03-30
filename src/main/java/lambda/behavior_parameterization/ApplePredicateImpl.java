package lambda.behavior_parameterization;

import common.pojos.fruit.Apple;

import java.awt.*;


public class ApplePredicateImpl {

    // ApplePredicate Strategy #1
    public static class AppleWeightPredicate implements ApplePredicate {
        public boolean test(Apple apple) {
            return apple.getWeight() > 150;
        }


    }

    // ApplePredicate Strategy #2
    public static class AppleColorPredicate implements ApplePredicate {
        public boolean test(Apple apple) {
            return Color.GREEN.equals(apple.getColor());
        }

    }

    // ApplePredicate Strategy #3
    public static class AppleRedAndHeavyPredicate implements ApplePredicate {
        public boolean test(Apple apple) {
            return Color.RED.equals(apple.getColor()) && apple.getWeight() > 150;
        }

    }

}