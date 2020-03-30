package innerClazz.anonymousInnerClass;

import innerClazz.Contents;

public class AnonymousInnerClassImplementingInterface2 {

    public static void main(String[] args) {
        AnonymousInnerClassImplementingInterface2 p = new AnonymousInnerClassImplementingInterface2();
        Contents c = p.getContents();
    }

    public Contents getContents() {
        return new MyContents();
    }

    class MyContents implements Contents {
        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }
}
