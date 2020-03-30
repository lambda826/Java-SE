/**
 *  @author Yunxiang He
 *  @date 2018-11-20 16:17
 */

package common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomIntGenerator {

    private static final int NUMBER = 10;
    private static final int RANGE = 30;

    public static int[] generateIntArray() {
        return generateIntArray(NUMBER, RANGE);
    }

    public static int[] generateIntArray(int number, int range) {
        int[] nums = new int[number];
        Random random = new Random();
        for (int i = 0; i < number; i++) {
            nums[i] = random.nextInt(range);
        }
        return nums;
    }

    public static List<Integer> generateIntList() {
        return generateIntList(NUMBER, RANGE);
    }

    public static List<Integer> generateIntList(int number, int range) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < number; i++) {
            list.add(random.nextInt(range));
        }
        return list;
    }
}
