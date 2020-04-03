package containers;

import reflection.pet.Hamster;
import reflection.pet.Pet;
import reflection.pet.Pets;
import reflection.pet.Rat;

import java.util.LinkedList;

import static utils.PrintUtil.println;

public class _112_LinkedListFeatures {
    public static void main(String[] args) {
        LinkedList<Pet> pets = new LinkedList<Pet>(Pets.arrayList(5));
        println(pets);
        // Identical:
        println("pets.getFirst(): " + pets.getFirst());
        println("pets.element(): " + pets.element());
        // Only differs in empty-list behavior:
        // -- returns null if the list is empty
        println("pets.peek(): " + pets.peek());
        // Identical; remove and return the first element:
        println("pets.remove(): " + pets.remove());
        println("pets.removeFirst(): " + pets.removeFirst());
        // Only differs in empty-list behavior:
        // -- returns null if the list is empty
        println("pets.poll(): " + pets.poll());
        println(pets);
        pets.addFirst(new Rat());
        println("After addFirst(): " + pets);
        pets.offer(Pets.randomPet());
        println("After offer(): " + pets);
        pets.add(Pets.randomPet());
        println("After add(): " + pets);
        pets.addLast(new Hamster());
        println("After addLast(): " + pets);
        println("pets.removeLast(): " + pets.removeLast());
    }
}