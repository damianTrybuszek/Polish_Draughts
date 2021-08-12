package game;

public class game {
    static String player1Name;
    static String player2Name;

    public static void start(){
        UI.printStatement("Welcome in the Polish draughts!");
        player1Name = Player.getPlayerName("first ");
        player2Name = Player.getPlayerName("second ");
    }

    public static void playRound(){
    }

    public static void tryToMakeMove(){
    }

    public static void checkForWinner(){
    }

}
