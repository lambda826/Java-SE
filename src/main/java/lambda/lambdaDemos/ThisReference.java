package lambda.lambdaDemos;


import static common.utils.PrintUtil.println;

public class ThisReference {

    public final int value = 4;
    private int i = 0;

    public static void main(String... args) {
        ThisReference instance = new ThisReference();
        instance.doIt();
        instance.method().apply(2);
        println(instance.i);
    }

    public void doIt() {
        int value = 6;
        Runnable r = new Runnable() { // Anonymous inner class
            public final int value = 5; // Different namespace

            public void run() {
                int value = 10;
                println(this.value); // this refers to r, this.value refers to 5
            }
        };
        r.run();
    }

    public ThisMethod method() {
        return (i) -> {
            this.i = i;
        };
    }

    private interface ThisMethod {
        void apply(int i);
    }
}
