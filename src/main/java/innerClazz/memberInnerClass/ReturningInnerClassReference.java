package innerClazz.memberInnerClass;

import static utils.PrintUtil.println;

public class ReturningInnerClassReference {

    public static void main(String[] args) {
        ReturningInnerClassReference p1 = new ReturningInnerClassReference();
        p1.ship("Tasmania");
        ReturningInnerClassReference p2 = new ReturningInnerClassReference();
        // Defining references to inner classes:
        ReturningInnerClassReference.Contents c = p2.contents();
        ReturningInnerClassReference.Destination d = p2.to("Borneo");
    }

    public void ship(String dest) {
        Contents c = contents();
        Destination d = to(dest);
        println(d.readLabel());
    }

    // Returning a reference to an inner class.
    public Contents contents() {
        return new Contents();
    }

    // Returning a reference to an inner class.
    public Destination to(String s) {
        return new Destination(s);
    }

    // Member inner class
    class Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    // Member inner class
    class Destination {
        private String label;

        Destination(String whereTo) {
            label = whereTo;
        }

        String readLabel() {
            return label;
        }
    }
}