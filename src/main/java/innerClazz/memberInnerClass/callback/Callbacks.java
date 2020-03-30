package innerClazz.memberInnerClass.callback;

import static common.utils.PrintUtil.println;

interface Increment {
    void increment();
}

class Callee1_Impl_Increment implements Increment {
    private int i = 0;

    @Override
    public void increment() {
        i++;
        println(i);
    }
}

class MyIncrement {
    static void f(MyIncrement myIncrement) {
        myIncrement.increment();
    }

    public void increment() {
        println("Other operation");
    }
}

// If your class must implement increment() in some other way, you must use an inner class:
class Callee2_Ext_MyIncrement extends MyIncrement {
    private int i = 0;

    @Override
    public void increment() {
        super.increment();
        ++i;
        println(i);
    }

    Increment getCallbackReference() {
        return new Closure_Impl_Increment();
    }

    private class Closure_Impl_Increment implements Increment {
        @Override
        public void increment() {
            // Specify outer-class method, otherwise you'd get an infinite recursion:
            Callee2_Ext_MyIncrement.this.increment();
        }
    }
}

// Accepts Increment instead of MyIncrement
class Caller {
    private Increment callbackReference;

    Caller(Increment callbackReference) {
        this.callbackReference = callbackReference;
    }

    void go() {
        callbackReference.increment();
    }
}

public class Callbacks {
    public static void main(String[] args) {
        Callee1_Impl_Increment c1 = new Callee1_Impl_Increment();
        Callee2_Ext_MyIncrement c2 = new Callee2_Ext_MyIncrement();
        MyIncrement.f(c2);

        Caller caller1 = new Caller(c1);
        Caller caller2 = new Caller(c2.getCallbackReference());

        caller1.go();
        caller1.go();
        caller2.go();
        caller2.go();
    }
}