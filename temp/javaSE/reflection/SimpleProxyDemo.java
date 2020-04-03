package reflection;

import static utils.PrintUtil.println;

interface Interface {
    void doSomething();

    void somethingElse(String arg);
}

class RealObject implements Interface {
    public void doSomething() {
        println("doSomething");
    }

    public void somethingElse(String arg) {
        println("somethingElse " + arg);
    }
}

class SimpleProxy implements Interface {
    private Interface proxied;

    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    public void doSomething() {
        println("SimpleProxy doSomething");
        proxied.doSomething();
    }

    public void somethingElse(String arg) {
        println("SimpleProxy somethingElse " + arg);
        proxied.somethingElse(arg);
    }
}

class SimpleProxyDemo {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
} /* Output:
  doSomething
  somethingElse bonobo
  SimpleProxy doSomething
  doSomething
  SimpleProxy somethingElse bonobo
  somethingElse bonobo
  *///:~
