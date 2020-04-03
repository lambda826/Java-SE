package enumerated;

import static utils.PrintUtil.println;

public enum OverrideConstantSpecific {
    NUT, BOLT, WASHER {
        void f() {
            println("Overridden method");
        }
    };

    void f() {
        println("default behavior");
    }

    public static void main(String[] args) {
        for (OverrideConstantSpecific ocs : values()) {
            printnb(ocs + ": ");
            ocs.f();
        }
    }
} /* Output:
  NUT: default behavior
  BOLT: default behavior
  WASHER: Overridden method
  *///:~
