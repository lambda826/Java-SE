package oop.polymorphism.music;

import static utils.PrintUtil.println;

public class _106_Brass extends _102_Instrument {

    public void play(_101_Note n) {
        println("Brass.play() " + n);
    }

}
