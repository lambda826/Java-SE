package innerClazz.memberInnerClass;

import static utils.PrintUtil.println;

class Egg {
    private Yolk y;

    public Egg() {
        println("New Egg()");
        y = new Yolk();
    }

    protected class Yolk {
        public Yolk() {
            println("Egg.Yolk()");
        }
    }
}


public class InnerClassCannotOverridden extends Egg {
    public static void main(String[] args) {
        new InnerClassCannotOverridden();
    }

    // They have different namespace
    public class Yolk {
        public Yolk() {
            println("BigEgg.Yolk()");
        }
    }
}