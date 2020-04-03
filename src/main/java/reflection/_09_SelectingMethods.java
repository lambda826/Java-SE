package reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static utils.PrintUtil.println;


public class _09_SelectingMethods {
    // Looking for particular methods in a dynamic proxy.
    static class MethodSelector implements InvocationHandler {
        private Object proxied;

        public MethodSelector(Object proxied) {
            this.proxied = proxied;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.getName().equals("interesting")) {
                println("Proxy detected the interesting method");
            }
            return method.invoke(proxied, args);
        }
    }

    interface SomeMethodsInterface {
        void boring1();

        void boring2();

        void interesting(String arg);

        void boring3();
    }

    static class SomeImplementation implements SomeMethodsInterface {
        @Override
        public void boring1() {
            println("boring1");
        }

        @Override

        public void boring2() {
            println("boring2");
        }

        @Override
        public void interesting(String arg) {
            println("interesting " + arg);
        }

        @Override
        public void boring3() {
            println("boring3");
        }
    }

    public static void main(String[] args) {
        SomeMethodsInterface proxy = (SomeMethodsInterface) Proxy.newProxyInstance(SomeMethodsInterface.class.getClassLoader(), new Class[] { SomeMethodsInterface.class }, new MethodSelector(new SomeImplementation()));
        proxy.boring1();
        proxy.boring2();
        proxy.interesting("bonobo");
        proxy.boring3();
    }
}