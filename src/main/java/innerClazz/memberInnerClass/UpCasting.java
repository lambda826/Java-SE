package innerClazz.memberInnerClass;

import innerClazz.Contents;
import innerClazz.Destination;

class Parcel4 {

    // Upcasting
    public Contents getContents() {
        return new PContents();
    }

    // Upcasting
    public Destination getDestination(String s) {
        return new PDestination(s);
    }

    private class PContents implements Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    protected class PDestination implements Destination {
        private String label;

        private PDestination(String whereTo) {
            label = whereTo;
        }

        public String readLabel() {
            return label;
        }
    }

}

public class UpCasting {

    // Upcasting
    public Contents getContents() {
        return new PContents();
    }

    // Upcasting
    public Destination getDestination(String s) {
        return new PDestination(s);
    }

    private class PContents implements Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    protected class PDestination implements Destination {
        private String label;

        private PDestination(String whereTo) {
            label = whereTo;
        }

        public String readLabel() {
            return label;
        }
    }

    public static void main(String[] args) {
        Parcel4 p = new Parcel4();
        Contents c = p.getContents();
        Destination d = p.getDestination("Tasmania");
        // Illegal -- can't access private class:
        //! Parcel4.PContents pc = p.new PContents();
    }
}
