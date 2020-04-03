package innerClazz.anonymousInnerClass;

import static utils.PrintUtil.println;

interface Game {
    boolean move();
}

interface GameFactory {
    Game getGame();
}

class Checkers implements Game {
    private static final int MOVES = 3;
    public static GameFactory factory = Checkers::new;
    private int moves = 0;

    private Checkers() {
    }

    @Override
    public boolean move() {
        println("Checkers move " + moves);
        return ++moves != MOVES;
    }
}

class Chess implements Game {
    private static final int MOVES = 4;
    public static GameFactory factory = Chess::new;
    private int moves = 0;

    private Chess() {
    }

    @Override
    public boolean move() {
        println("Chess move " + moves);
        return ++moves != MOVES;
    }
}

public class FactoriesGames {
    public static void main(String[] args) {
        playGame(Checkers.factory);
        playGame(Chess.factory);
    }

    public static void playGame(GameFactory factory) {
        Game s = factory.getGame();
        while (s.move()) {
        }
    }
}