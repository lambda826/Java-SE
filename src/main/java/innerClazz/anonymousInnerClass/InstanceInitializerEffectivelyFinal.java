package innerClazz.anonymousInnerClass;

import static common.utils.PrintUtil.println;

abstract class Base {
    public Base(int i) {
        println("Base constructor, i = " + i);
    }

    public abstract void f();
}

public class InstanceInitializerEffectivelyFinal {

    public static void main(String[] args) {
        Base base = getBase(47);
        base.f();
    }

    public static Base getBase(int i) {
        i++;
        return new Base(i) { // i is effectively final
            // i++;
            {
                // i is effectively final
                // i++;
                println("Inside instance initializer");
            }

            public void f() {
                println("In anonymous f()");
            }
        };
    }
}