package enumerated;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

import static common.utils.PrintUtil.println;
import static utils.Print.printnb;

enum Explore {
    HERE, THERE
}

public class _107_Reflection_Values {

    public static Set<String> analyze(Class<?> enumClass) {
        println("----- Analyzing " + enumClass + " -----");
        println("Interfaces:");
        for (Type t : enumClass.getGenericInterfaces()) {
            println(t);
        }
        println("Base: " + enumClass.getSuperclass());
        println("Methods: ");
        Set<String> methods = new TreeSet<String>();
        for (Method m : enumClass.getMethods()) {
            methods.add(m.getName());
        }
        println(methods);
        return methods;
    }

    public static void main(String[] args) {
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);
        println("Explore.containsAll(Enum)? " + exploreMethods.containsAll(enumMethods));
        printnb("Explore.removeAll(Enum): ");
        exploreMethods.removeAll(enumMethods);
        println(exploreMethods);
    }
}