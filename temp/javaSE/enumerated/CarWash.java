package enumerated;

import static common.utils.PrintUtil.println;

public class CarWash {
    public enum Cycle {
        UNDERBODY {
            void action() {
                println("Spraying the underbody");
            }
        },
        WHEELWASH {
            void action() {
                println("Washing the wheels");
            }
        },
        PREWASH {
            void action() {
                println("Loosening the dirt");
            }
        },
        BASIC {
            void action() {
                println("The basic wash");
            }
        },
        HOTWAX {
            void action() {
                println("Applying hot wax");
            }
        },
        RINSE {
            void action() {
                println("Rinsing");
            }
        },
        BLOWDRY {
            void action() {
                println("Blowing dry");
            }
        };

        abstract void action();
    }

    EnumSet<Cycle> cycles = EnumSet.of(Cycle.BASIC, Cycle.RINSE);

    public void add(Cycle cycle) {
        cycles.add(cycle);
    }

    public void washCar() {
        for (Cycle c : cycles) {
            c.action();
        }
    }

    public String toString() {
        return cycles.toString();
    }

    public static void main(String[] args) {
        CarWash wash = new CarWash();
        println(wash);
        wash.washCar();
        // Order of addition is unimportant:
        wash.add(Cycle.BLOWDRY);
        wash.add(Cycle.BLOWDRY); // Duplicates ignored
        wash.add(Cycle.RINSE);
        wash.add(Cycle.HOTWAX);
        println(wash);
        wash.washCar();
    }
} /* Output:
  [BASIC, RINSE]
  The basic wash
  Rinsing
  [BASIC, HOTWAX, RINSE, BLOWDRY]
  The basic wash
  Applying hot wax
  Rinsing
  Blowing dry
  *///:~
