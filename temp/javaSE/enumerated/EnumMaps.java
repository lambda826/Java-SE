//: enumerated/EnumMaps.java
// Basics of EnumMaps.
package enumerated;

import static enumerated.AlarmPoints.*;
import static utils.PrintUtil.println;

interface Command {
    void action();
}

public class EnumMaps {
    public static void main(String[] args) {
        EnumMap<AlarmPoints, Command> em = new EnumMap<AlarmPoints, Command>(AlarmPoints.class);
        em.put(KITCHEN, new Command() {
            public void action() {
                println("Kitchen fire!");
            }
        });
        em.put(BATHROOM, new Command() {
            public void action() {
                println("Bathroom alert!");
            }
        });
        for (Map.Entry<AlarmPoints, Command> e : em.entrySet()) {
            printnb(e.getKey() + ": ");
            e.getValue().action();
        }
        try { // If there's no value for a particular key:
            em.get(UTILITY).action();
        } catch (Exception e) {
            println(e);
        }
    }
} /* Output:
  BATHROOM: Bathroom alert!
  KITCHEN: Kitchen fire!
  java.lang.NullPointerException
  *///:~
