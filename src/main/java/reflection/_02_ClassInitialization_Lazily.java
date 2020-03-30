package reflection;

import java.util.Random;

import static common.utils.PrintUtil.println;


/**
 * Note that creating a reference to a Class object using ".class" doesn’t automatically initialize the Class object
 *     There are actually three steps in preparing a class for use:
 *         Loading, which is performed by the class loader
 *             This finds the bytecodes and creates a Class object from those bytecodes
 *         Linking
 *             The link phase verifies the bytecodes in the class, allocates storage for static fields, and if necessary, resolves all references to other classes made by this class
 *         Initialization
 *             If there’s a super class, initialize that
 *             Execute static initializers and static initialization blocks
 *         Initialization is delayed until the first reference to a static method (the constructor is implicitly static) or to a non-constant static field
 */
public class _02_ClassInitialization_Lazily {

    public static Random rand = new Random(47);

    static class Initable1 {
        static final int staticFinal = 47;
        static final int staticFinal2 = _02_ClassInitialization_Lazily.rand.nextInt(1000);

        static {
            println("Initializing Initable1");
        }
    }

    static class Initable2 {
        static int staticNonFinal = 74;

        static {
            println("Initializing Initable2");
        }
    }

    static class Initable3 {
        static int staticNonFinal = 147;

        static {
            println("Initializing Initable3");
        }
    }


    public static void main(String[] args) throws Exception {
        Class initable = Initable1.class;
        println("After creating Initable1 ref");
        println(Initable1.staticFinal); // Does not trigger initialization
        println(Initable1.staticFinal2); // Does trigger initialization
        println(Initable2.staticNonFinal); // Does trigger initialization
        Class initable3 = Class.forName("reflection._02_ClassInitialization_Lazily$Initable3");
        println("After creating Initable3 ref");
        println(Initable3.staticNonFinal);
    }
}