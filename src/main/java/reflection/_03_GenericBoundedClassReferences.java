package reflection;

import reflection._01_ClassNameDifference.SubClass;

public class _03_GenericBoundedClassReferences {

    public static void main(String[] args) throws Exception {
        ///////////////////////////////////////////////////////////////////
        Class intClass = int.class;
        intClass = double.class; // Legal
        Class<Integer> genericIntClass = int.class;
        // genericIntClass = double.class; // Illegal
        genericIntClass = Integer.class; // Same thing

        ///////////////////////////////////////////////////////////////////
        Class<? extends Number> bounded = int.class;
        bounded = double.class;
        bounded = Number.class;
        // Or anything else derived from Number.

        ///////////////////////////////////////////////////////////////////
        // An interesting thing happens when you use the generic syntax for Class objects:
        // newlnstance() will return the exact type of the object, rather than just a basic Object
        Class<SubClass> clazz = SubClass.class;
        SubClass SubClass = clazz.newInstance(); // Produces exact type
        Class<? super SubClass> up = clazz.getSuperclass();
        //                Class<SuperClass> up2 = clazz.getSuperclass(); // This won't compile:
        Object obj = up.newInstance(); // Only produces Object:
    }
}
