package generics.maker;

import java.lang.reflect.Array;
import java.util.Arrays;

import static common.utils.PrintUtil.println;

public class ArrayMaker<T> {
    private Class<T> kind;

    public ArrayMaker(Class<T> kind) {
        this.kind = kind;
    }

    @SuppressWarnings("unchecked")
    T[] create(int size) {
        // Even though kind is stored as Class<T>, erasure means that it is actually just being stored as a Class, with no parameter. 
        // So, when you do something with it, as in creating an array, Array.newInstance() doesn't actually have the type information that’s implied in kind;
        // so it cannot produce the specific result, which must therefore be cast, which produces a warning that you cannot satisfy.
        // Array.newInstance() is the recommended approach for creating arrays in generics.
        return (T[]) Array.newInstance(kind, size);
    }

    public static void main(String[] args) {
        ArrayMaker<String> stringMaker = new ArrayMaker<>(String.class);
        String[] stringArray = stringMaker.create(9);
        println(Arrays.toString(stringArray));
    }
}