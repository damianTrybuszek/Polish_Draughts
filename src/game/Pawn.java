package game;

import java.util.HashMap;

public class Pawn {
    public final boolean IS_WHITE;
    private final boolean IS_QUEEN;
    private int coordinateI = -1;
    private int coordinateJ = -1;

    public Pawn(boolean isWhite, boolean isQueen, int coordinateI, int coordinateJ) {
        this.IS_WHITE = isWhite;
        this.IS_QUEEN = isQueen;
        this.coordinateI = coordinateI;
        this.coordinateJ = coordinateJ;
    }

    public boolean isIS_WHITE() {
        return IS_WHITE;
    }

    public char getPawnSymbol() {
        return '●';
    }

    public boolean isIS_QUEEN() {
        return IS_QUEEN;
    }

    public HashMap<String, Integer> getCoordinates() {
        HashMap<String, Integer> coordinates = new HashMap<>();
        coordinates.put("coordinateI", this.coordinateI);
        coordinates.put("coordinateJ", this.coordinateJ);
        return coordinates;
    }
}
