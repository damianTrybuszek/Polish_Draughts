package game;

import java.util.Scanner;

import static game.UI.checkIfString;

public class Player {
    private final String NAME;
    private final boolean IS_WHITE;
    private final int pawnsLeft;


    public Player(String name, boolean isWhite, int pawnsLeft) {
        this.NAME = name;
        this.IS_WHITE = isWhite;
        this.pawnsLeft = pawnsLeft;
    }

    public String getNAME() {
        return this.NAME;
    }

    public boolean isIsWhite() {
        return this.IS_WHITE;
    }

    public static String getPlayerName(String stringPlayerNumber) {
        Scanner scanner = new Scanner(System.in);
        String statement = UI.stringBuilder("Please provide a player name: ", stringPlayerNumber, 17);
        String playerName;
        do {
            UI.printAnotherStatement(statement);
            playerName = scanner.nextLine();
        } while (checkIfString(playerName));
        return playerName;
    }

    public int getPawnsLeft() {
        return pawnsLeft;
    }
}
