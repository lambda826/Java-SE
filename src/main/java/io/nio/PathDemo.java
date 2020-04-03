package io.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

import static utils.PrintUtil.println;

public class PathDemo {

    public static void main(String[] args) {
        Path path = Paths.get("abc", "def", "ghi");
        println("getFileSystem(): " + path.getFileSystem());
        println("getRoot(): " + path.getRoot());
        println("getParent(): " + path.getParent());
        println("getName(0): " + path.getName(0));
        println("getName(1): " + path.getName(1));
        println("getName(2): " + path.getName(2));
        // println("getName(-1): " + path.getName(-1)); // java.lang.IllegalArgumentException
        // println("getName(3): " + path.getName(3)); // java.lang.IllegalArgumentException
        println("isAbsolute(): " + path.isAbsolute());
    }

}
