package oop.polymorphism.music;

import static common.utils.PrintUtil.println;

class Instrument {

    void play(_101_Note n) {
        println("Instrument.play() " + n);
    }

    String what() {
        return "Instrument";
    }

    void adjust() {
        println("Adjusting Instrument");
    }
}

class Wind extends Instrument {

    void play(_101_Note n) {
        println("Wind.play() " + n);
    }

    String what() {
        return "Wind";
    }

    void adjust() {
        println("Adjusting Wind");
    }
}

class Percussion extends Instrument {

    void play(_101_Note n) {
        println("Percussion.play() " + n);
    }

    String what() {
        return "Percussion";
    }

    void adjust() {
        println("Adjusting Percussion");
    }
}

class Stringed extends Instrument {

    void play(_101_Note n) {
        println("Stringed.play() " + n);
    }

    String what() {
        return "Stringed";
    }

    void adjust() {
        println("Adjusting Stringed");
    }
}

class Brass extends Wind {

    void play(_101_Note n) {
        println("Brass.play() " + n);
    }

    void adjust() {
        println("Adjusting Brass");
    }
}

class Woodwind extends Wind {

    void play(_101_Note n) {
        println("Woodwind.play() " + n);
    }

    String what() {
        return "Woodwind";
    }
}

public class _108_Music3 {

    // Doesn't care about type, so new types added to the system still work right:
    public static void tune(Instrument i) {
        i.play(_101_Note.MIDDLE_C);
    }

    public static void tuneAll(Instrument[] e) {
        for (Instrument i : e) {
            tune(i);
        }
    }

    public static void main(String[] args) {
        // Upcasting during addition to the array:
        Instrument[] orchestra = { new Wind(), new Percussion(), new Stringed(), new Brass(), new Woodwind() };
        tuneAll(orchestra);

        Instrument i = new Woodwind();
        i.adjust();
    }
}