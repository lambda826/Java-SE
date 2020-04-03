package io;

import java.nio.ByteBuffer;

import static utils.PrintUtil.println;
import static utils.PrintUtil.printnb;

// Getting different representations from a ByteBuffer

public class GetData {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        // Allocation automatically zeroes the ByteBuffer:
        int i = 0;
        while (i++ < bb.limit()) {
            if (bb.get() != 0) {
                println("nonzero");
            }
        }
        println("i = " + i);
        bb.rewind();
        // Store and read a char array:
        bb.asCharBuffer().put("Howdy!");
        char c;
        while ((c = bb.getChar()) != 0) {
            printnb(c + " ");
        }
        println();
        bb.rewind();
        // Store and read a short:
        bb.asShortBuffer().put((short) 471142);
        println(bb.getShort());
        bb.rewind();
        // Store and read an int:
        bb.asIntBuffer().put(99471142);
        println(bb.getInt());
        bb.rewind();
        // Store and read a long:
        bb.asLongBuffer().put(99471142);
        println(bb.getLong());
        bb.rewind();
        // Store and read a float:
        bb.asFloatBuffer().put(99471142);
        println(bb.getFloat());
        bb.rewind();
        // Store and read a double:
        bb.asDoubleBuffer().put(99471142);
        println(bb.getDouble());
        bb.rewind();
    }
} /* Output:
  i = 1025
  H o w d y !
  12390
  99471142
  99471142
  9.9471144E7
  9.9471142E7
  *///:~
