package innerClazz.LocalInnerClass;

import innerClazz.Destination;

import static common.utils.PrintUtil.println;

public class InnerClassInMethod {

    public static void main(String[] args) {
        InnerClassInMethod p = new InnerClassInMethod();
        Destination d = p.destination("Tasmania");
        println(d.readLabel());
    }

    public Destination destination(String s) {

        // Nesting a class within a method.
        class PDestination implements Destination {
            private String label;

            private PDestination(String whereTo) {
                label = whereTo;
            }

            @Override
            public String readLabel() {
                return label;
            }
        }

        return new PDestination(s);
    }
}
