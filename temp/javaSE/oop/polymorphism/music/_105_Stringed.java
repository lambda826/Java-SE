package oop.polymorphism.music;


import static utils.PrintUtil.println;

public class _105_Stringed extends _102_Instrument {

    public void play(_101_Note n) {
        println("Stringed.play() " + n);
    }

}
