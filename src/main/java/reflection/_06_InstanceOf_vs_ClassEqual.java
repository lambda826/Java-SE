package reflection;

import static utils.PrintUtil.println;

/**
 * In keeping with the concept of type, instanceof says, "Are you this class, or a class Sub from this class?"
 * On the other hand, if you compare the actual Class objects using ==, there is no concern with inheritance—it’s either the exact type or it isn’t
 */
public class _06_InstanceOf_vs_ClassEqual {
    static class Super {
    }

    static class Sub extends Super {
    }

    public static void main(String[] args) {

        test(new Super());
        test(new Sub());
    }


    static void test(Object x) {

        println("Testing x of type " + x.getClass());
        println("x instanceof Super " + (x instanceof Super));
        println("x instanceof Sub " + (x instanceof Sub));
        println("Super.isInstance(x) " + Super.class.isInstance(x));
        println("Sub.isInstance(x) " + Sub.class.isInstance(x));
        println("x.getClass() == Super.class " + (x.getClass() == Super.class));
        println("x.getClass() == Sub.class " + (x.getClass() == Sub.class));
        println("x.getClass().equals(Super.class)) " + (x.getClass().equals(Super.class)));
        println("x.getClass().equals(Sub.class)) " + (x.getClass().equals(Sub.class)));
        println();
    }
}