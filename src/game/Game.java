package game;

import java.util.Objects;
import  java.lang.Math;

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

//        String startStatement = UI.stringBuilder("You start, . Your pawns are white!", player1Name, 10);
        boardSize = Board.getBoardSize();
//        UI.printStatement(startStatement);
        UI.printStatement("The Pawns of " + player1Name+ " are white, and the Pawns of " +player2Name+ " are black.");
        UI.printStatement(" ");
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
//            UI.printStatement("Your move " + nextMovePlayer);
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
        if (!((row > 0 && row <= boardSize) && (col > 0 && col <= boardSize))) {
            System.out.println("The pawn coordinates should be between 1-" + boardSize);
            return false;

        }
        else if((row + col) % 2 != 0){
            System.out.println("You tried to move onto White Field! You can only move on the Black ones");
            return false;
        }
        else {
            if (!startingPosition) {
                if (((Board) board).getFields()[row-1][col-1] == null){
                return true;}
                else if ((((Board) board).getFields()[row-1][col-1].IS_WHITE != IS_WHITE)){
                    return true;
                }
                else if ((((Board) board).getFields()[row-1][col-1].IS_WHITE == IS_WHITE)){
                    System.out.println("You tried to move to the place, where is your pawn!");
                    return false;
                }
                else{
                    return false;
                }
            }
             else {
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

    public static Boolean checkIfNotTooFar(int row, int col, int newRow, int newCol){
        if(Math.abs(row - newRow) == 0 || Math.abs(row - newRow) == 1 && Math.abs(col - newCol) == 0 || Math.abs(col - newCol) == 1){
            return true;
        }
        else
        {
            System.out.println("You wanted to move too far!");
            return false;
    }
    }

    public static void checkForWinner(){
    }

}
