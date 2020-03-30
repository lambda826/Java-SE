package reflection;

import reflection._07_SimpleProxyDemo.RealObject;
import reflection._07_SimpleProxyDemo.SomeInterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static common.utils.PrintUtil.println;

public class _08_SimpleDynamicProxy {

    static class DynamicProxyHandler implements InvocationHandler {
        private Object proxied;

        public DynamicProxyHandler(Object proxied) {
            this.proxied = proxied;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            println("**** proxy: " + proxy.getClass() + ", method: " + method + ", args: " + args);
            if (args != null) {
                for (Object arg : args) {
                    println("  " + arg);
                }
            }
            return method.invoke(proxied, args);
        }
    }

    public static void consumer(SomeInterface someInterface) {
        someInterface.doSomething();
        someInterface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);
        // Insert a proxy and call again:
        SomeInterface proxy = (SomeInterface) Proxy.newProxyInstance(SomeInterface.class.getClassLoader(), new Class[] { SomeInterface.class }, new DynamicProxyHandler(real));
        consumer(proxy);
    }
}