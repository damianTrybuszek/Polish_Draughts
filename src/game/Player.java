package game;

import java.util.Scanner;

import static game.UI.checkIfString;

public class Player {
    private final String name;
    private final boolean isWhite;
    //    private final char playerPawnSymbol;
    private final int pawnsLeft;


    public Player(String name, boolean isWhite,/*, char indicatorChar*/int pawnsLeft) {
        this.name = name;
        this.isWhite = isWhite;
//        this.playerPawnSymbol = indicatorChar;
        this.pawnsLeft = pawnsLeft;
    }

    public String getName() {
        return this.name;
    }

    public boolean isIsWhite() {
        return this.isWhite;
    }

//    public char getPlayerPawnSymbol() {
//        return this.playerPawnSymbol;
//    }

    public static String getPlayerName(String stringPlayerNumber) {
        Scanner scanner = new Scanner(System.in);
        int offset = 17;
        String originalStatement = "Please provide a player name: ";
        StringBuilder builder = new StringBuilder(originalStatement);
        builder.insert(offset, stringPlayerNumber);
        String statement = builder.toString();
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
