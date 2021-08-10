package game;

public class Pawn {
    private final boolean IS_WHITE;
    private final char SYMBOL_CHAR;
    private final boolean IS_QUEEN;
//    private final int [][] coordinates;

    public Pawn(boolean isWhite, boolean isQueen/*, int[][] coordinates*/) {
        this.IS_WHITE = isWhite;

        if (isWhite) {
            this.SYMBOL_CHAR = 'W';
        } else {
            this.SYMBOL_CHAR = 'B';
        }
        this.IS_QUEEN = isQueen;
//        this.coordinates = coordinates;
    }

    public boolean isIS_WHITE() {
        return IS_WHITE;
    }

    public char getSYMBOL_CHAR() {
        return SYMBOL_CHAR;
    }

    public boolean isIS_QUEEN() {
        return IS_QUEEN;
    }

//    public int[][] getCoordinates() {
//        return coordinates;
//    }
}
