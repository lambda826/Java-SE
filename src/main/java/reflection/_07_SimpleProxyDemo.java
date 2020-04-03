package reflection;

import static utils.PrintUtil.println;

class _07_SimpleProxyDemo {
    interface SomeInterface {
        void doSomething();

        void somethingElse(String arg);
    }

    static class RealObject implements SomeInterface {
        public void doSomething() {
            println("doSomething");
        }

        public void somethingElse(String arg) {
            println("somethingElse " + arg);
        }
    }

    static class SimpleProxy implements SomeInterface {

        private SomeInterface proxied;

        public SimpleProxy(SomeInterface proxied) {
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

    public static void consumer(SomeInterface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
}