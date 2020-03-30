package innerClazz.memberInnerClass;

interface interfaceA {
}

interface interfaceB {
    void method();
}

class AB implements interfaceA, interfaceB {
    @Override
    public void method() {}
}

class A implements interfaceA {
    interfaceB makeB() {
        // Anonymous inner class:
        return () -> {};
    }
}

public class MultiInterfaces {
    public static void main(String[] args) {
        AB ab = new AB();
        A a = new A();
        takesA(ab);
        takesA(a);
        takesB(ab);
        takesB(a.makeB());
    }

    static void takesA(interfaceA a) {
    }

    static void takesB(interfaceB b) {
    }
}