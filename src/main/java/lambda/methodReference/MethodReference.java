package lambda.methodReference;

import java.util.function.Function;

import static utils.PrintUtil.println;

public class MethodReference {

    private static String inStr = "Lambdas add power to Java";

    public static String stringOp(Function<String, String> function, String s) {
        return function.apply(s);
    }

    public static String staticReverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public String nonStaticReverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public String instantMethod() {
        inStr = "123123";
        inStr = new StringBuilder(inStr).reverse().toString();
        return inStr;
    }


    public static void main(String[] args) {

        // Reference to a Static Method
        stringOp(MethodReference::staticReverse, inStr);
        // Reference to an Instance Method of a Particular Object
        stringOp(new MethodReference()::nonStaticReverse, inStr);
        // Instant method reference
        Function<MethodReference, String> function = MethodReference::instantMethod;
        println(function.apply(new MethodReference()));

    }

}
