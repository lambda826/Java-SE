package containers.collection.test;

import static utils.PrintUtil.println;

public class _05_RandomBounds {
    static void usage() {
        println("Usage:");
        println("\tRandomBounds lower");
        println("\tRandomBounds upper");
        System.exit(1);
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            usage();
        }
        if (args[0].equals("lower")) {
            while (Math.random() != 0.0) {
                ; // Keep trying
            }
            println("Produced 0.0!");
        } else if (args[0].equals("upper")) {
            while (Math.random() != 1.0) {
                ; // Keep trying
            }
            println("Produced 1.0!");
        } else {
            usage();
        }
    }
}