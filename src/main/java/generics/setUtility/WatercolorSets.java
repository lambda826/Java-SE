package generics.setUtility;


import java.util.EnumSet;
import java.util.Set;

import static utils.PrintUtil.println;
import static generics.setUtility.Sets.complement;
import static generics.setUtility.Sets.difference;
import static generics.setUtility.Sets.intersection;
import static generics.setUtility.Sets.union;
import static generics.setUtility.WatercolorsEnum.BRILLIANT_RED;
import static generics.setUtility.WatercolorsEnum.BURNT_UMBER;
import static generics.setUtility.WatercolorsEnum.CERULEAN_BLUE_HUE;
import static generics.setUtility.WatercolorsEnum.VIRIDIAN_HUE;

public class WatercolorSets {
    public static void main(String[] args) {
        Set<WatercolorsEnum> set1 = EnumSet.range(BRILLIANT_RED, VIRIDIAN_HUE);
        Set<WatercolorsEnum> set2 = EnumSet.range(CERULEAN_BLUE_HUE, BURNT_UMBER);
        println("set1: " + set1);
        println("set2: " + set2);
        println("union(set1, set2): " + union(set1, set2));
        Set<WatercolorsEnum> subset = intersection(set1, set2);
        println("intersection(set1, set2): " + subset);
        println("difference(set1, subset): " + difference(set1, subset));
        println("difference(set2, subset): " + difference(set2, subset));
        println("complement(set1, set2): " + complement(set1, set2));
    }
}