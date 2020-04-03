package generics.OTHERS;

// No latent typing in Java

import reflection.typeInfo.pet.Dog;

import static utils.PrintUtil.println;

class PerformingDog extends Dog implements Performs {
    public void speak() {
        println("Woof!");
    }

    public void sit() {
        println("Sitting");
    }

    public void reproduce() {
    }
}

class Robot implements Performs {
    public void speak() {
        println("Click!");
    }

    public void sit() {
        println("Clank!");
    }

    public void oilChange() {
    }
}

class Communicate {
    public static <T extends Performs> void perform(T performer) {
        performer.speak();
        performer.sit();
    }
}

public class DogsAndRobots {
    public static void main(String[] args) {
        PerformingDog d = new PerformingDog();
        Robot r = new Robot();
        Communicate.perform(d);
        Communicate.perform(r);
    }
} /* Output:
  Woof!
  Sitting
  Click!
  Clank!
  *///:~
