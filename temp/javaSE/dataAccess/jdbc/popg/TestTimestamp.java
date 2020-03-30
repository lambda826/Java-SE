/**
 *  @author heyx8
 *  @date 06/29/2019
 */

package dataAccess.jdbc.popg;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestTimestamp {

    public static void main(String[] args) {
        Timestamp t = Timestamp.valueOf("2019-02-02 00:00:00");
        List<Timestamp> list = new ArrayList<>();
        list.add(t);
        t = Timestamp.valueOf("2019-02-03 00:00:00");

        list.add(t);
        System.out.println(list);


        Map<Integer, String> map = new HashMap<>();
        map.put(2, null);
        map.computeIfAbsent(2, (a) -> "2");
        System.out.println(map);
    }
}
