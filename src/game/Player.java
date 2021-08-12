package game;

import java.util.Scanner;

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

    public static String getPlayerName() {
        Scanner scanner = new Scanner(System.in);
        //todo validate input, welcome players
        System.out.println("Please provide a player name:");
        return scanner.nextLine();
    }

    public int getPawnsLeft() {
        return pawnsLeft;
    }
}
