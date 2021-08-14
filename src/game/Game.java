package game;

import java.util.Objects;

public class Game {
    static String player1Name;
    static String player2Name;
    static String winnerName = "";
    static int boardSize;


    public static void start(){
        /*
        This method starts the game between two players.
         */
        // TODO clear console
        UI.printStatement("Welcome in the Polish draughts!");
        player1Name = Player.getPlayerName("first ");
        player2Name = Player.getPlayerName("second ");
        String startStatement = UI.stringBuilder("You start, . Your pawns are white!", player1Name, 11);
        boardSize = Board.getBoardSize();
        UI.printStatement(startStatement);
    }

    public static String playRound(int correctMoveCounter){
        /*
        This method determined one-round actions, checks which player is next and whether there is a winner.
         */
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

    public static Boolean tryToMakeMove(Object board, int row, int col, Boolean startingPosition, String player) {
        /*
        This method checks if the starting position from user input is a valid pawn and if the ending
        position is within board boundaries
         */
        boolean IS_WHITE = Objects.equals(player, player1Name);
        if (!((row > 0 && row < 11) && (col > 0 && col < 11))) {
            System.out.println("The pawn coordinates should be between 1-10!");
            return false;
        } else {
            if (!startingPosition) {
                return true;
            } else {
                if (((Board) board).getFields()[row-1][col-1] == null) {
                    System.out.println("The are no pawn!");
                    return false;
                } else{
                    if (((Board) board).getFields()[row-1][col-1].IS_WHITE == IS_WHITE){
                        return true;
                    } else {
                        System.out.println("This is not your pawn!");
                        return false;
                    }
                }
            }
        }
    }

    public static void checkForWinner(){
    }

}
