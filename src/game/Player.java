package game;

import java.util.Scanner;

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
