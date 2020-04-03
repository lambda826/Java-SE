package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFile {
    public static void main(String[] args) throws IOException {
        String content1 = " /**\r\n" + "  *  @author: Yunxiang He\r\n" + "  *  @date  : 2018-06-27\r\n" + "  */\r\n" + "\r\n" + "package leetcode;\r\n" + "\r\n" + "/*\r\n" + "\r\n" + "\r\n" + "\r\n" + "*/\r\n" + "\r\n" + "public class ";
        String content2 = " {\r\n" + "\r\n" + "}\r\n";
        String filePath = "D:\\temp\\algo\\";

        BufferedReader bf = new BufferedReader(new FileReader(new File("D:\\01__Development\\Coding Practice\\Algorithms\\Algorithms\\bin\\utils\\Algorithm_Questions.txt")));
        String s;
        while ((s = bf.readLine()) != null) {
            String fileName = "";
            if (s.substring(0, s.indexOf("_")).length() == 2) {
                fileName += "_00" + s;
            } else if (s.substring(0, s.indexOf("_")).length() == 1) {

                fileName += "_000" + s;
            } else {
                fileName += "_0" + s;
            }
            filePath += fileName + ".java";
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
                FileWriter fw = new FileWriter(filePath, true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(content1 + fileName + content2);
                bw.close();
                fw.close();

            }
            filePath = "D:\\temp\\algo\\";
        }
        filePath = "D:\\temp\\sql\\";
        s = "";
        bf = new BufferedReader(new FileReader(new File("D:\\01__Development\\Coding Practice\\Algorithms\\Algorithms\\bin\\utils\\SQL_Questions.txt")));
        while ((s = bf.readLine()) != null) {
            String fileName = "";
            if (s.substring(0, s.indexOf("_")).length() == 2) {
                fileName += "_00" + s;
            } else if (s.substring(0, s.indexOf("_")).length() == 1) {

                fileName += "_000" + s;
            } else {
                fileName += "_0" + s;
            }
            filePath += fileName + ".sql";
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
                FileWriter fw = new FileWriter(filePath, true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(content1 + fileName + content2);
                bw.close();
                fw.close();

            }
            filePath = "D:\\temp\\sql\\";
        }

    }
}
