package innerClazz.anonymousInnerClass;


import innerClazz.Contents;

public class AnonymousInnerClassImplementingInterface {

    public static void main(String[] args) {
        AnonymousInnerClassImplementingInterface p = new AnonymousInnerClassImplementingInterface();
        Contents c = p.getContents();
    }

    public Contents getContents() {
        // Returning an instance of an anonymous inner class
        return new Contents() { // Insert a class definition
            private int i = 11;

            @Override
            public int value() {
                return i;
            }
        }; // Semicolon required in this case
    }
}
