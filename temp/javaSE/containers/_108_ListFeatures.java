package containers;

import reflection.typeInfo.pet.Cymric;
import reflection.typeInfo.pet.Hamster;
import reflection.typeInfo.pet.Mouse;
import reflection.typeInfo.pet.Pet;
import reflection.typeInfo.pet.Pets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static common.utils.PrintUtil.println;

public class _108_ListFeatures {
    public static void main(String[] args) {
        Random rand = new Random(47);
        List<Pet> pets = Pets.arrayList(7);
        println("1: " + pets);
        Hamster h = new Hamster();
        pets.add(h);
        println("2: " + pets);
        println("3: " + pets.contains(h));
        pets.remove(h);
        Pet p = pets.get(2);
        println("4: " + p + " " + pets.indexOf(p));
        Pet cymric = new Cymric();
        println("5: " + pets.indexOf(cymric));
        println("6: " + pets.remove(cymric));
        // Must be the exact object:
        println("7: " + pets.remove(p));
        println("8: " + pets);
        // Insert at an index
        pets.add(3, new Mouse());
        println("9: " + pets);
        List<Pet> sub = pets.subList(1, 4);
        println("subList: " + sub);
        println("10: " + pets.containsAll(sub));
        // In-place sort
        Collections.sort(sub);
        println("sorted subList: " + sub);
        // Order is not important in containsAll():
        println("11: " + pets.containsAll(sub));
        // Mix it up
        Collections.shuffle(sub, rand);
        println("shuffled subList: " + sub);
        println("12: " + pets.containsAll(sub));
        List<Pet> copy = new ArrayList<Pet>(pets);
        sub = Arrays.asList(pets.get(1), pets.get(4));
        println("sub: " + sub);
        copy.retainAll(sub);
        println("13: " + copy);
        // Get a fresh copy
        copy = new ArrayList<Pet>(pets);
        // Remove by index
        copy.remove(2);
        println("14: " + copy);
        // Only removes exact objects
        copy.removeAll(sub);
        println("15: " + copy);
        copy.set(1, new Mouse());
        println("16: " + copy);
        // Insert a list in the middle
        copy.addAll(2, sub);
        println("17: " + copy);
        println("18: " + pets.isEmpty());
        pets.clear();
        println("19: " + pets);
        println("20: " + pets.isEmpty());
        pets.addAll(Pets.arrayList(4));
        println("21: " + pets);
        Object[] o = pets.toArray();
        println("22: " + o[3]);
        Pet[] pa = pets.toArray(new Pet[0]);
        println("23: " + pa[3].id());
    }
}