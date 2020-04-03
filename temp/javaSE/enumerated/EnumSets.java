//: enumerated/EnumSets.java
// Operations on EnumSets
package enumerated;

import java.util.EnumSet;

import static utils.PrintUtil.println;
import static enumerated.AlarmPoints.BATHROOM;
import static enumerated.AlarmPoints.KITCHEN;
import static enumerated.AlarmPoints.OFFICE1;
import static enumerated.AlarmPoints.OFFICE4;
import static enumerated.AlarmPoints.STAIR1;
import static enumerated.AlarmPoints.STAIR2;

Util.println;

public class EnumSets {
    public static void main(String[] args) {
        EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class); // Empty set
        points.add(BATHROOM);
        println(points);
        points.addAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
        println(points);
        points = EnumSet.allOf(AlarmPoints.class);
        points.removeAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
        println(points);
        points.removeAll(EnumSet.range(OFFICE1, OFFICE4));
        println(points);
        points = EnumSet.complementOf(points);
        println(points);
    }
} /* Output:
  [BATHROOM]
  [STAIR1, STAIR2, BATHROOM, KITCHEN]
  [LOBBY, OFFICE1, OFFICE2, OFFICE3, OFFICE4, BATHROOM, UTILITY]
  [LOBBY, BATHROOM, UTILITY]
  [STAIR1, STAIR2, OFFICE1, OFFICE2, OFFICE3, OFFICE4, KITCHEN]
  *///:~
