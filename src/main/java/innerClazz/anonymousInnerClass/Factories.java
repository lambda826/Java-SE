package innerClazz.anonymousInnerClass;

import static utils.PrintUtil.println;

interface Service {
    void method1();

    void method2();
}

// Produce service
@FunctionalInterface
interface ServiceFactory {
    Service getService();
}


/**
 * The constructors for Implementation1 and Implementation2 can be private, and there’s no need to create a named class as the factory.
 * In addition, you often only need a single factory object, and so here it has been created as a static field in the Service implementation.
 */
class Implementation1 implements Service {
    // Method reference replacing anonymous class
    public static ServiceFactory factory = Implementation1::new;

    private Implementation1() {
    }

    @Override
    public void method1() {
        println("Implementation1 method1");
    }

    @Override
    public void method2() {
        println("Implementation1 method2");
    }
}

class Implementation2 implements Service {
    public static ServiceFactory factory = Implementation2::new;

    private Implementation2() {
    }

    @Override
    public void method1() {
        println("Implementation2 method1");
    }

    @Override
    public void method2() {
        println("Implementation2 method2");
    }
}

public class Factories {
    public static void main(String[] args) {
        serviceConsumer(Implementation1.factory);
        // Implementations are completely interchangeable:
        serviceConsumer(Implementation2.factory);
    }

    // Behavior
    public static void serviceConsumer(ServiceFactory factory) {
        Service s = factory.getService();
        s.method1();
        s.method2();
    }
}