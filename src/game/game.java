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
        String startStatement = UI.stringBuilder("You start, . Your pawns are white!", player1Name, 11);
        boardSize = Board.getBoardSize();
        UI.printStatement(startStatement);
    }

    public static void playRound(){
    }

    public static void tryToMakeMove(){
    }

    public static void checkForWinner(){
    }

}
