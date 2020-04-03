package exceptions;

import static utils.PrintUtil.println;

public class _04_ExtraFeatures {

    /**
     * You can add extra constructors and members:
     */
    static class MyException extends Exception {
        private int x;

        public MyException() {
        }

        public MyException(String msg) {
            super(msg);
        }

        public MyException(String msg, int x) {
            super(msg);
            this.x = x;
        }

        public int val() {
            return x;
        }

        @Override
        public String getMessage() {
            return "Detail Message: " + x + " " + super.getMessage();
        }
    }

    public static void f() throws MyException {
        throw new MyException();
    }

    public static void g() throws MyException {
        throw new MyException("Originated in g()");
    }

    public static void h() throws MyException {
        throw new MyException("Originated in h()", 47);
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }
        try {
            g();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }
        try {
            h();
        } catch (MyException e) {
            e.printStackTrace(System.out);
            println("e.val() = " + e.val());
        }
    }
}