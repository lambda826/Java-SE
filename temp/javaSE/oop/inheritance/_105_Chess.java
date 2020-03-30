package oop.inheritance;

import static common.utils.PrintUtil.println;

class Game {

    Game(int i) {
        println("Game constructor");
    }

}

class BoardGame extends Game {

    BoardGame(int i) {
        super(i);
        println("BoardGame constructor");
    }

}

public class _105_Chess extends BoardGame {

    _105_Chess() {
        super(11);
        println("Chess constructor");
    }

    public static void main(String[] args) {
        _105_Chess x = new _105_Chess();
    }

}