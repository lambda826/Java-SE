package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *  @author: Yunxiang He
 *  @date  : 2018-07-17 01:42
 */

public class TotalLines {
    static int constant[] = new int[3];

    public static void main(String[] args) {
        File f = new File("D:\\01__Development\\Coding Practice");
        println(f);
        System.out.println("*********目录下所有行数总和：************");
        System.out.println("总行数：" + constant[0] + ",");
    }

    public static void println(File f) {
        File[] file = f.listFiles();

        for (int i = 0; i < file.length; i++) {
            if (file[i].isDirectory()) {
                println(file[i]);
            } else {
                String filepath = file[i].getAbsolutePath();
                if (filepath.endsWith(".java")) {
                    File readfile = new File(filepath);
                    statistic(readfile);
                }
            }
        }
    }

    private static synchronized int[] statistic(File file) {

        int totalCount = 0;
        int notesCount = 0;
        int spaceCount = 0;

        boolean flagNode = false;

        String regxNodeBegin = "\\s*/\\*.*";
        String regxNodeEnd = ".*\\*/\\s*";
        String regx = "//.*";
        String regxSpace = "\\s*";

        BufferedReader br = null;
        try {
            String line = null;
            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
                totalCount++;
                if (line.matches(regxNodeBegin) && line.matches(regxNodeEnd)) {
                    ++notesCount;
                }
                if (line.matches(regxNodeBegin)) {
                    ++notesCount;
                    flagNode = true;
                } else if (line.matches(regxNodeEnd)) {
                    ++notesCount;
                    flagNode = false;
                } else if (line.matches(regxSpace)) {
                    ++spaceCount;
                } else if (line.matches(regx)) {
                    ++notesCount;
                } else if (flagNode) {
                    ++notesCount;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        constant[0] += totalCount;
        constant[1] += notesCount;
        constant[2] += spaceCount;
        System.out.println("总行数：" + totalCount + ", 注释：" + notesCount + ", 空行： " + spaceCount + ", 文件：" + file.getName());
        return constant;
    }
}
