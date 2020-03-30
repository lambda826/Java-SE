package lambda.lambdaDemos;

import static common.utils.PrintUtil.println;

public class Lambdas_vs_Anonymous {

    // () -> void
    public interface Task {
        void execute();
    }

    // 1. this and super
    // 2. shadow variables
    public void shadowVariablesDemo() {
        int a = 10;
        Runnable r1 = () -> {
            // Compile error
            // int a = 2;
            println(a);
        };

        Runnable r2 = new Runnable() {
            public void run() {
                // Ok
                int a = 2;
                println(a);
            }
        };
    }

    // 3. overload ambiguity
    public static void overloadingAmbiguity() {
        // () -> void
        // doSomething(() -> System.out.println("Ambiguity"));
        doSomething((Task) () -> println("Ambiguity"));
        doSomething((Runnable) () -> println("Ambiguity"));
    }

    // () -> void
    public static void doSomething(Task t) {
        t.execute();
    }

    public static void doSomething(Runnable r) {
        r.run();
    }

    public static void main(String[] args) {
        overloadingAmbiguity();
    }

}
