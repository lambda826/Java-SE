package generics.bounds;

import java.util.List;

public class _03_EpicBattle {

    interface SuperPowerInterface {
    }

    interface SuperPower1Interface extends SuperPowerInterface {
        void power1();
    }

    interface SuperPower2Interface extends SuperPowerInterface {
        void power2();
    }

    interface SuperPower3Interface extends SuperPowerInterface {
        void power3();
    }

    static class SuperHero<P extends SuperPowerInterface> {
        P power;

        SuperHero(P power) {
            this.power = power;
        }

        P getPower() {
            return power;
        }
    }

    static class SuperHero1<P extends SuperPower1Interface> extends SuperHero<P> {
        SuperHero1(P power) {
            super(power);
        }

        void see() {
            power.power1();
        }
    }

    static class SuperHero2<P extends SuperPower2Interface & SuperPower3Interface> extends SuperHero<P> {
        SuperHero2(P power) {
            super(power);
        }

        void hear() {
            power.power2();
        }

        void smell() {
            power.power3();
        }
    }

    static class SuperHearSmell implements SuperPower2Interface, SuperPower3Interface {
        public void power2() {
        }

        public void power3() {
        }
    }

    static class DogBoy extends SuperHero2<SuperHearSmell> {
        DogBoy() {
            super(new SuperHearSmell());
        }
    }

    // Bounds in generic methods:
    static <P extends SuperPower2Interface> void useSuperHearing(SuperHero<P> hero) {
        hero.getPower().power2();
    }

    static <P extends SuperPower2Interface & SuperPower3Interface> void superFind(SuperHero<P> hero) {
        hero.getPower().power2();
        hero.getPower().power3();
    }

    public static void main(String[] args) {
        DogBoy dogBoy = new DogBoy();
        useSuperHearing(dogBoy);
        superFind(dogBoy);
        // You can do this:
        List<? extends SuperPower2Interface> audioBoys;
        // Wildcards are limited to a single bound.
        // List<? extends SuperHearing & SuperSmell> dogBoys;
    }
}