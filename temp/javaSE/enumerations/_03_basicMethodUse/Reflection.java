package enumerations._03_basicMethodUse;

import utils.OSExecute;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

import static utils.PrintUtil.println;

enum Explore {
    HERE, THERE
}

/*
 * Analyzing enums using reflection.
 */
public class Reflection {
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
        // Decompile the code for the enum:
        OSExecute.command("javap Explore");
    }
}
/* Output:
  ----- Analyzing class Explore -----
  Interfaces:
  Base: class java.lang.Enum
  Methods:
  [compareTo, equals, getClass, getDeclaringClass, hashCode, name, notify, notifyAll, ordinal, toString, valueOf, values, wait]
  ----- Analyzing class java.lang.Enum -----
  Interfaces:
  java.lang.Comparable<E>
  interface java.io.Serializable
  Base: class java.lang.Object
  Methods:
  [compareTo, equals, getClass, getDeclaringClass, hashCode, name, notify, notifyAll, ordinal, toString, valueOf, wait]
  Explore.containsAll(Enum)? true
  Explore.removeAll(Enum): [values]
  Compiled from "Reflection.java"
  final class Explore extends java.lang.Enum{
    public static final Explore HERE;
    public static final Explore THERE;
    public static final Explore[] values();
    public static Explore valueOf(java.lang.String);
    static {};
  }
  *///:~
