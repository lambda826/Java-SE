package innerClazz.memberInnerClass;

import static utils.PrintUtil.println;

public class SimpleInnerClassDemo {

    public static void main(String[] args) {
        SimpleInnerClassDemo p = new SimpleInnerClassDemo();
        p.ship("Tasmania");
    }

    // Using inner classes looks just like using any other class, within Parcel1:
    public void ship(String dest) {
        Contents c = new Contents();
        Destination d = new Destination(dest);
        println(d.readLabel());
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