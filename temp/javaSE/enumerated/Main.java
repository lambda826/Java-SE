package enumerated;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] preferences = new int[len];
        for (int i = 0; i < preferences.length; ++i) {
            preferences[i] = sc.nextInt();
        }
        int[][] queries = new int[sc.nextInt()][3];
        for (int i = 0; i < queries.length; ++i) {
            for (int j = 0; j < 3; j++) {
                queries[i][j] = sc.nextInt();
            }
        }
        for (int[] query : queries) {
            int count = 0;
            for (int i = query[0]; i < query[1]; ++i) {
                if (preferences[i - 1] == query[2]) {
                    ++count;
                }
            }
            System.out.println(count);
        }
    }
}