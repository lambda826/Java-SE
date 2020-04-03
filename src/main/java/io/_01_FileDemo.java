package io;

import java.io.File;
import java.io.IOException;

import static common.Constants.LINE;
import static utils.PrintUtil.println;

public class _01_FileDemo {

    private static File path1 = new File("E:\\Download");
    private static File path2 = new File("..");
    private static File path3 = new File(".");

    public static void list() {
        println(LINE + " list()");
        for (String fileName : path1.list()) {
            println(fileName);
        }
    }

    public static void listFiles() {
        println(LINE + " listFiles()");
        for (File file : path1.listFiles()) {
            println(file);
        }
    }

    public static void getCanonicalPath() throws IOException {
        println(LINE + " getCanonicalPath()");
        println(path2.getCanonicalFile());
        println(path3.getCanonicalFile());
    }

    public static void getAbsolutePath() {
        println(LINE + " getAbsolutePath()");
        println(path2.getAbsolutePath());
        println(path3.getAbsolutePath());

    }

    public static void main(String[] args) throws IOException {
        list();
        listFiles();
        getCanonicalPath();
        getAbsolutePath();
    }
}
