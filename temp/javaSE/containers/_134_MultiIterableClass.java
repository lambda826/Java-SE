package containers;

public class _134_MultiIterableClass extends _130_IterableClass {
    public Iterable<String> reversed() {
        return new Iterable<String>() {
            public Iterator<String> iterator() {
                return new Iterator<String>() {
                    int current = words.length - 1;

                    public boolean hasNext() {
                        return current > -1;
                    }

                    public String next() {
                        return words[current--];
                    }

                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }

    public Iterable<String> randomized() {
        return new Iterable<String>() {
            public Iterator<String> iterator() {
                List<String> shuffled = new ArrayList<String>(Arrays.asList(words));
                Collections.shuffle(shuffled, new Random(47));
                return shuffled.iterator();
            }
        };
    }

    public static void main(String[] args) {
        _134_MultiIterableClass mic = new _134_MultiIterableClass();
        for (String s : mic.reversed()) {
            System.out.println(s + " ");
        }
        System.out.println();
        for (String s : mic.randomized()) {
            System.out.println(s + " ");
        }
        System.out.println();
        for (String s : mic) {
            System.out.println(s + " ");
        }
    }
}