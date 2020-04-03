package lambda.methodReference;


import static utils.PrintUtil.println;

public class MethodRef_Generic {

    interface MyFunc3<T> {
        int func(T[] vals, T v);
    }

    // Notice that countMatching() is generic, but MyArrayOps is not
    static class MyArrayOps {
        static <T> int countMatching(T[] vals, T v) {
            int count = 0;
            for (int i = 0; i < vals.length; i++) {
                if (vals[i] == v) {
                    count++;
                }
            }
            return count;
        }
    }

    // This method has the MyFunc3 functional interface as the type of its first parameter
    // The other two parameters receive an array and a value, both of type T
    static <T> int myOp(MyFunc3<T> f, T[] vals, T v) {
        return f.func(vals, v);
    }

    public static void main(String[] args) {
        Integer[] vals = { 1, 2, 3, 4, 2, 3, 4, 4, 5 };
        String[] strs = { "One", "Two", "Three", "Two" };
        int count;

        // Notice that it occurs after the ::
        // This syntax can be generalized: When a generic method is specified as a method reference
        // its type argument comes after the :: and before the method name
        // Explicitly specifying the type argument is not required in this situation because the type argument would have been automatically inferred
        count = myOp(MyArrayOps::<Integer>countMatching, vals, 4);
        println("vals contains " + count + " 4s");

        count = myOp(MyArrayOps::<String>countMatching, strs, "Two");
        println("strs contains " + count + " Twos");
    }

}
