package innerClazz.memberInnerClass;


public class CreateInnerClassObj {
    public static void main(String[] args) {
        CreateInnerClassObj outerObj = new CreateInnerClassObj();
        // Using .new to create instances of inner classes.
        // Must use instance of outer class to create an instance of the inner class:
        CreateInnerClassObj.Contents innerclassContents = outerObj.new Contents();
        CreateInnerClassObj.Destination innerclassCDestination = outerObj.new Destination("Tasmania");
    }

    class Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

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