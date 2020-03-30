package generics.maker;

import java.util.ArrayList;
import java.util.List;

public class ListMaker<T> {

    List<T> create() {
        // The compiler gives no warnings, even though we know (from erasure) that the <T> in new ArrayList<T>() inside create() is removed—at run time there’s no <T> inside the class, so it seems meaningless.
        // But if you follow this idea and change the expression to new ArrayList(), the compiler gives a warning.
        return new ArrayList<T>();
    }

    public static void main(String[] args) {
        ListMaker<String> stringMaker = new ListMaker<String>();
        List<String> stringList = stringMaker.create();
    }
}