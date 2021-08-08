package game;

public class Player {
    private final String name;
    private final boolean isWhite;
    private final char indicatorChar;

    public Player(String name, boolean isWhite, char indicatorChar) {
        this.name = name;
        this.isWhite = isWhite;
        this.indicatorChar = indicatorChar;
    }

    public String getName() {
        return this.name;
    }

    public boolean isIsWhite() {
        return this.isWhite;
    }

    public char getIndicatorChar() {
        return this.indicatorChar;
    }
}
