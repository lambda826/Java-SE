package containers;

import reflection.pet.Cat;
import reflection.pet.Dog;
import reflection.pet.Hamster;
import reflection.pet.Pet;

import java.util.HashMap;
import java.util.Map;

import static common.utils.PrintUtil.println;

public class _122_PetMap {
    public static void main(String[] args) {
        Map<String, Pet> petMap = new HashMap<String, Pet>();
        petMap.put("My Cat", new Cat("Molly"));
        petMap.put("My Dog", new Dog("Ginger"));
        petMap.put("My Hamster", new Hamster("Bosco"));
        println(petMap);
        Pet dog = petMap.get("My Dog");
        println(dog);
        println(petMap.containsKey("My Dog"));
        println(petMap.containsValue(dog));
    }
}