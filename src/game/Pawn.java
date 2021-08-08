package game;

public class Pawn {
    private final boolean isWhite;
    private final char indicatorChar;
    private final boolean isQueen;
//    private final int [][] coordinates;

    public Pawn(boolean isWhite, boolean isQueen/*, int[][] coordinates*/) {
        this.isWhite = isWhite;

        if (isWhite) {
            this.indicatorChar = 'W';
        } else {
            this.indicatorChar = 'B';
        }
        this.isQueen = isQueen;
//        this.coordinates = coordinates;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public char getIndicatorChar() {
        return indicatorChar;
    }

    public boolean isQueen() {
        return isQueen;
    }

//    public int[][] getCoordinates() {
//        return coordinates;
//    }
}
