package game;

public class Pawn {
    private final boolean isWhite;
    private final char symbolChar;
    private final boolean isQueen;
//    private final int [][] coordinates;

    public Pawn(boolean isWhite, boolean isQueen/*, int[][] coordinates*/) {
        this.isWhite = isWhite;

        if (isWhite) {
            this.symbolChar = 'W';
        } else {
            this.symbolChar = 'B';
        }
        this.isQueen = isQueen;
//        this.coordinates = coordinates;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public char getSymbolChar() {
        return symbolChar;
    }

    public boolean isQueen() {
        return isQueen;
    }

//    public int[][] getCoordinates() {
//        return coordinates;
//    }
}
