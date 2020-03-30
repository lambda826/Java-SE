package generics.OTHERS;

import static common.utils.PrintUtil.println;

// Using Reflection to produce latent typing.

// Does not implement Performs:
class Mime {
    public void walkAgainstTheWind() {
    }

    public void sit() {
        println("Pretending to sit");
    }

    public void pushInvisibleWalls() {
    }

    public String toString() {
        return "Mime";
    }
}

// Does not implement Performs:
class SmartDog {
    public void speak() {
        println("Woof!");
    }

    public void sit() {
        println("Sitting");
    }

    public void reproduce() {
    }
}

class CommunicateReflectively {
    public static void perform(Object speaker) {
        Class<?> spkr = speaker.getClass();
        try {
            try {
                Method speak = spkr.getMethod("speak");
                speak.invoke(speaker);
            } catch (NoSuchMethodException e) {
                println(speaker + " cannot speak");
            }
            try {
                Method sit = spkr.getMethod("sit");
                sit.invoke(speaker);
            } catch (NoSuchMethodException e) {
                println(speaker + " cannot sit");
            }
        } catch (Exception e) {
            throw new RuntimeException(speaker.toString(), e);
        }
    }
}

public class LatentReflection {
    public static void main(String[] args) {
        CommunicateReflectively.perform(new SmartDog());
        CommunicateReflectively.perform(new Robot());
        CommunicateReflectively.perform(new Mime());
    }
} /* Output:
  Woof!
  Sitting
  Click!
  Clank!
  Mime cannot speak
  Pretending to sit
  *///:~
