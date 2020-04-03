package containers;

import reflection.pet.Cat;
import reflection.pet.Cymric;
import reflection.pet.Dog;
import reflection.pet.Mutt;
import reflection.pet.Person;
import reflection.pet.Pet;
import reflection.pet.Pug;
import reflection.pet.Rat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static utils.PrintUtil.println;

public class _123_MapOfList {
    public static Map<Person, List<? extends Pet>> petPeople = new HashMap<Person, List<? extends Pet>>();

    static {
        petPeople.put(new Person("Dawn"), Arrays.asList(new Cymric("Molly"), new Mutt("Spot")));
        petPeople.put(new Person("Kate"), Arrays.asList(new Cat("Shackleton"), new Cat("Elsie May"), new Dog("Margrett")));
        petPeople.put(new Person("Marilyn"), Arrays.asList(new Pug("Louie aka Louis Snorkelstein Dupree"), new Cat("Stanford aka Stinky el Negro"), new Cat("Pinkola")));
        petPeople.put(new Person("Luke"), Arrays.asList(new Rat("Fuzzy"), new Rat("Fizzy")));
        petPeople.put(new Person("Isaac"), Arrays.asList(new Rat("Freckly")));
    }

    public static void main(String[] args) {
        println("People: " + petPeople.keySet());
        println("Pets: " + petPeople.values());
        for (Person person : petPeople.keySet()) {
            println(person + " has:");
            for (Pet pet : petPeople.get(person)) {
                println("    " + pet);
            }
        }
    }
}