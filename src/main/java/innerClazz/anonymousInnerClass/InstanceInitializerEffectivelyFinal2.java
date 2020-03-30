package innerClazz.anonymousInnerClass;

import innerClazz.Destination;

public class InstanceInitializerEffectivelyFinal2 {

    public static void main(String[] args) {
        InstanceInitializerEffectivelyFinal2 p = new InstanceInitializerEffectivelyFinal2();
        Destination d = p.destination("Tasmania", 101.395F);
    }

    // Effectively final
    public Destination destination(final String dest, final float price) {
        return new Destination() {
            private int cost;
            private String label = dest;

            // Instance initialization for each object:
            {
                cost = Math.round(price);
                if (cost > 100) {
                    System.out.println("Over budget!");
                }
            }

            @Override
            public String readLabel() {
                return label;
            }
        };
    }
}