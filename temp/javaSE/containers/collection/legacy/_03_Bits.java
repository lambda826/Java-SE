package containers.collection.legacy;

import java.util.BitSet;
import java.util.Random;

import static common.utils.PrintUtil.println;

public class _03_Bits {
    public static void printBitSet(BitSet b) {
        println("bits: " + b);
        StringBuilder bbits = new StringBuilder();
        for (int j = 0; j < b.size(); j++) {
            bbits.append(b.get(j) ? "1" : "0");
        }
        println("bit pattern: " + bbits);
    }

    public static void main(String[] args) {
        Random rand = new Random(47);
        // Take the LSB of nextInt():
        byte bt = (byte) rand.nextInt();
        BitSet bb = new BitSet();
        for (int i = 7; i >= 0; i--) {
            if (((1 << i) & bt) != 0) {
                bb.set(i);
            } else {
                bb.clear(i);
            }
        }
        println("byte value: " + bt);
        printBitSet(bb);

        short st = (short) rand.nextInt();
        BitSet bs = new BitSet();
        for (int i = 15; i >= 0; i--) {
            if (((1 << i) & st) != 0) {
                bs.set(i);
            } else {
                bs.clear(i);
            }
        }
        println("short value: " + st);
        printBitSet(bs);

        int it = rand.nextInt();
        BitSet bi = new BitSet();
        for (int i = 31; i >= 0; i--) {
            if (((1 << i) & it) != 0) {
                bi.set(i);
            } else {
                bi.clear(i);
            }
        }
        println("int value: " + it);
        printBitSet(bi);

        // Test bitsets >= 64 bits:
        BitSet b127 = new BitSet();
        b127.set(127);
        println("set bit 127: " + b127);
        BitSet b255 = new BitSet(65);
        b255.set(255);
        println("set bit 255: " + b255);
        BitSet b1023 = new BitSet(512);
        b1023.set(1023);
        b1023.set(1024);
        println("set bit 1023: " + b1023);
    }
}