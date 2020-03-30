package innerClazz.anonymousInnerClass;

import innerClazz.Destination;

public class InitializationFinalVariable {

    public static void main(String[] args) {
        InitializationFinalVariable p = new InitializationFinalVariable();
        Destination d = p.destination("Tasmania");
    }

    // Argument must be final to use inside anonymous inner class:
    public Destination destination(final String dest) {
        return new Destination() {
            private String label = dest; // initialization

            public String readLabel() {
                return label;
            }
        };
    }
}
