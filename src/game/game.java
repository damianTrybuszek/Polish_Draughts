package game;

public class game {
    static String player1Name;
    static String player2Name;
    static int boardSize;

    public static void start(){
        // TODO clear console
        UI.printStatement("Welcome in the Polish draughts!");
        player1Name = Player.getPlayerName("first ");
        player2Name = Player.getPlayerName("second ");
        boardSize = Board.getBoardSize();
    }

    public static void playRound(){
    }

    public static void tryToMakeMove(){
    }

    public static void checkForWinner(){
    }

}
