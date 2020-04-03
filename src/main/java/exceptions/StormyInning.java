package exceptions;

import static utils.PrintUtil.println;

class Exception1 extends Exception {}
class Exception11 extends Exception1 {}
class Exception12 extends Exception1 {}
class Exception122 extends Exception12 {}

class Exception2 extends Exception {}
class Exception22 extends Exception2 {}

abstract class Inning {
    public Inning() throws Exception1 {}
    public void walk() {} // Throws no checked exceptions
    public void event() throws Exception1 {} // Doesn't actually have to throw anything
    public abstract void atBat_Exception11_Exception12() throws Exception11, Exception12;
}

interface Storm {
    void event() throws Exception22;
    void rainHard() throws Exception22;
}

/**
 * exceptions of overridden method in sub class cannot exceed the one in sup class
 *
 * When you override a method, you can throw only the exceptions that have been specified in the base-class version of the method.
 *     This is a useful restriction, since it means that code that works with the base class will automatically work with any object derived from the base class including exceptions.
 *
 * The restriction on exceptions does not apply to constructors.
 * You can see in StormyInning that a constructor can throw anything it wants, regardless of what the base-class constructor throws.
 * However, since a base-class constructor must always be called one way or another (here, the default constructor is called automatically),
 *     the derived-class constructor must declare any base-class constructor exceptions in its exception specification.
 *
 * A derived-class constructor cannot catch exceptions thrown by its base-class constructor.
 */
public class StormyInning extends Inning implements Storm {
    // OK to add new exceptions for constructors, but you must deal with the base constructor exceptions (Exception1):
    public StormyInning() throws Exception22, Exception1 {}
    public StormyInning(String s) throws Exception12, Exception1 {}

    // Regular methods must conform to base class
    // public void walk() throws Exception122 {}

    // You can choose to not throw any exceptions, even if the base version does
    @Override public void event() {}

    // Interface CANNOT add exceptions to existing methods from the base class
    // @Override public void event() throws Exception22 {}

    // If the method doesn't already exist in the base class, the exception is OK
    @Override public void rainHard() throws Exception22 {}

    // Overridden methods can throw inherited exceptions
    @Override public void atBat_Exception11_Exception12() throws Exception122 {}

    public static void main(String[] args) {
        try {
            StormyInning si = new StormyInning();
            si.atBat_Exception11_Exception12();
        } catch (Exception122 e) {
            println("Pop foul");
        } catch (Exception22 e) {
            println("Rained out");
        } catch (Exception1 e) {
            println("Generic baseball exception");
        }
        // Exception11 not thrown in derived version.
        try {
            // What happens if you upcast?
            Inning i = new StormyInning();
            i.atBat_Exception11_Exception12();
            // You must catch the exceptions from the base-class version of the method:
        } catch (Exception11 e) {
            println("Exception11");
        } catch (Exception12 e) {
            println("Exception12");
        } catch (Exception22 e) {
            println("Exception22");
        } catch (Exception1 e) {
            println("Exception1");
        }
    }
}
