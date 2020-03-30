package generics.OTHERS;

import generics._03_GenericMethods._114_New;
import reflection.pet.Person;
import reflection.pet.Pet;
import typeinfo.pets.*;
import util.*;

public class SimplerPets {
    public static void main(String[] args) {
        Map<Person, List<? extends Pet>> petPeople = _114_New.map();
        // Rest of the code is the same...
    }
} ///:~
