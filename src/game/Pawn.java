package game;

import java.util.HashMap;

public class Pawn {
    public final boolean IS_WHITE;
    public final boolean IS_QUEEN;
    public int coordinateI = -1;
    public int coordinateJ = -1;


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

    public int getCoordinateI(){return coordinateI;}

    public int getCoordinateJ() {
        return coordinateJ;
    }

    public HashMap<String, Integer> getCoordinates() {
        HashMap<String, Integer> coordinates = new HashMap<>();
        coordinates.put("coordinateI", this.coordinateI);
        coordinates.put("coordinateJ", this.coordinateJ);
        return coordinates;
    }


}
