package game;

public class game {
    static String player1Name;
    static String player2Name;
    static int boardSize;
    static String winnerName;

    public static void start(){
        // TODO clear console
        UI.printStatement("Welcome in the Polish draughts!");
        player1Name = Player.getPlayerName("first ");
        player2Name = Player.getPlayerName("second ");
        String startStatement = UI.stringBuilder("You start, . Your pawns are white!", player1Name, 11);
        boardSize = Board.getBoardSize();
        UI.printStatement(startStatement);
    }

    public static String playRound(int correctMoveCounter){
        String nextMovePlayer = player1Name;
        if (correctMoveCounter % 2 == 1){
            nextMovePlayer = player2Name;
        }
        if (winnerName.isBlank()){
            UI.printStatement("Your move " + nextMovePlayer);
            return nextMovePlayer;
        } else {
            return winnerName;
        }
    }

    public static void tryToMakeMove(){
    }

    public static void checkForWinner(){
    }

}
