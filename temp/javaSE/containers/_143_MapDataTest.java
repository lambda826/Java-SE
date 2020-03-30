package containers;

import containers.array._128_CountingGenerator;
import containers.array._130_RandomGenerator;
import generics._109_Generator;

import java.util.Iterator;

import static common.utils.PrintUtil.println;

class Letters implements _109_Generator<_141_Pair<Integer, String>>, Iterable<Integer> {
    private int size = 9;
    private int number = 1;
    private char letter = 'A';

    public _141_Pair<Integer, String> next() {
        return new _141_Pair<Integer, String>(number++, "" + letter++);
    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            public Integer next() {
                return number++;
            }

            public boolean hasNext() {
                return number < size;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}

public class _143_MapDataTest {
    public static void main(String[] args) {
        // Pair Generator:
        println(_142_MapData.map(new Letters(), 11));
        // Two separate generators:
        println(_142_MapData.map(new _128_CountingGenerator.Character(), new _130_RandomGenerator.String(3), 8));
        // A key Generator and a single value:
        println(_142_MapData.map(new _128_CountingGenerator.Character(), "Value", 6));
        // An Iterable and a value Generator:
        println(_142_MapData.map(new Letters(), new _130_RandomGenerator.String(3)));
        // An Iterable and a single value:
        println(_142_MapData.map(new Letters(), "Pop"));
    }
}
