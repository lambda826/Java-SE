package enumerations._03_basicMethodUse;

import static utils.PrintUtil.println;
import static utils.PrintUtil.printnb;

enum Shrubbery {
    GROUND, CRAWLING, HANGING
}

public class EnumClassBasicFeatures {
    public static void main(String[] args) {
        for (Shrubbery s : Shrubbery.values()) {
            println(s + " ordinal: " + s.ordinal());
            printnb(s.compareTo(Shrubbery.CRAWLING) + " ");
            printnb(s.equals(Shrubbery.CRAWLING) + " ");
            println(s == Shrubbery.CRAWLING);
            println(s.getDeclaringClass());
            println(s.name());
            println("----------------------");
        }
        // Produce an enum value from a string name:
        for (String s : "HANGING CRAWLING GROUND".split(" ")) {
            Shrubbery shrub = Enum.valueOf(Shrubbery.class, s);
            println(shrub);
        }
    }
}