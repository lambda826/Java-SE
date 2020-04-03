package io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

import static utils.PrintUtil.println;
import static utils.PrintUtil.printnb;

public class ViewBuffers {
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[] { 0, 0, 0, 0, 0, 0, 0, 'a' });
        bb.rewind();
        printnb("Byte Buffer ");
        while (bb.hasRemaining()) {
            printnb(bb.position() + " -> " + bb.get() + ", ");
        }
        println();
        CharBuffer cb = ((ByteBuffer) bb.rewind()).asCharBuffer();
        printnb("Char Buffer ");
        while (cb.hasRemaining()) {
            printnb(cb.position() + " -> " + cb.get() + ", ");
        }
        println();
        FloatBuffer fb = ((ByteBuffer) bb.rewind()).asFloatBuffer();
        printnb("Float Buffer ");
        while (fb.hasRemaining()) {
            printnb(fb.position() + " -> " + fb.get() + ", ");
        }
        println();
        IntBuffer ib = ((ByteBuffer) bb.rewind()).asIntBuffer();
        printnb("Int Buffer ");
        while (ib.hasRemaining()) {
            printnb(ib.position() + " -> " + ib.get() + ", ");
        }
        println();
        LongBuffer lb = ((ByteBuffer) bb.rewind()).asLongBuffer();
        printnb("Long Buffer ");
        while (lb.hasRemaining()) {
            printnb(lb.position() + " -> " + lb.get() + ", ");
        }
        println();
        ShortBuffer sb = ((ByteBuffer) bb.rewind()).asShortBuffer();
        printnb("Short Buffer ");
        while (sb.hasRemaining()) {
            printnb(sb.position() + " -> " + sb.get() + ", ");
        }
        println();
        DoubleBuffer db = ((ByteBuffer) bb.rewind()).asDoubleBuffer();
        printnb("Double Buffer ");
        while (db.hasRemaining()) {
            printnb(db.position() + " -> " + db.get() + ", ");
        }
    }
} /* Output:
  Byte Buffer 0 -> 0, 1 -> 0, 2 -> 0, 3 -> 0, 4 -> 0, 5 -> 0, 6 -> 0, 7 -> 97,
  Char Buffer 0 ->  , 1 ->  , 2 ->  , 3 -> a,
  Float Buffer 0 -> 0.0, 1 -> 1.36E-43,
  Int Buffer 0 -> 0, 1 -> 97,
  Long Buffer 0 -> 97,
  Short Buffer 0 -> 0, 1 -> 0, 2 -> 0, 3 -> 97,
  Double Buffer 0 -> 4.8E-322,
  *///:~
