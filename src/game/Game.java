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
        boardSize = Board.getBoardSize();
        UI.printStatement("The Pawns of " + player1Name + " are white, and the Pawns of " + player2Name + " are black.");
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
            return nextMovePlayer;
        } else {
            return winnerName;
        }
    }

    public static Boolean tryToMakeMove(Object board, int row, int col, Boolean startingPosition, String player, int newRow, int newCol) {
        /*
        This method checks if the starting position from user input is a valid pawn and if the ending
        position is within board boundaries
         */
        boolean IS_WHITE = Objects.equals(player, player1Name);
        if (!((row > 0 && row <= boardSize) && (col > 0 && col <= boardSize))) {
            System.out.println("The pawn coordinates should be between 1-" + boardSize);
            return false;

        }
        else if((newRow + newCol) % 2 != 0){
            //check if we try to go on the black field
            System.out.println("You tried to move onto White Field! You can only move on the Black ones");
            return false;
        }
        else {
            if (!startingPosition) {
                Boolean notToFar = checkIfNotTooFar(row, col, newRow, newCol);
                if (notToFar) {
                    if (((Board) board).getFields()[newRow - 1][newCol - 1] == null) {
                        //check if the field is empty
                        return true;
                    } else if ((((Board) board).getFields()[newRow - 1][newCol - 1].IS_WHITE != IS_WHITE)) {
                        //check if the opponent Pawn is placed on  the field we chose
                        int rowDiff = newRow - row;
                        int colDiff = newCol - col;
                        if ((((Board) board).getFields()[newRow - 1 + rowDiff][newCol - 1 + colDiff] == null)) {
                            //check if the field behind the pawn is empty
                            return true;
                        }
                        else {
                            System.out.println("You can not beat!");
                            return false;
                        }
                    } else if ((((Board) board).getFields()[newRow - 1][newCol - 1].IS_WHITE == IS_WHITE)) {
                        System.out.println("You tried to move to the place, where is your pawn!");
                        return false;
                    } else {
                        return false;
                    }
                }
                else {
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
        //the method checks, if the place which we chose is not too far
        if(Math.abs(row - newRow) == 0 || Math.abs(row - newRow) == 1 && Math.abs(col - newCol) == 0 || Math.abs(col - newCol) == 1){
            return true;
        }
        else
        {
            System.out.println("You wanted to move too far!");
            return false;
        }
    }


    public static Boolean checkBoundaries(int rowOrCol ){
        return 0 <= rowOrCol && rowOrCol < boardSize;
    }

    public static Boolean downMultiplyMoves(Object board, int downRow, int downCol, int doubleDownRow, int doubleDownCol){
        // next down move not null
        if (checkBoundaries(downRow) && checkBoundaries(downCol)) {
            if (((Board) board).getFields()[downRow][downCol] != null){
                // next down move is enemy
                if (!((Board) board).getFields()[downRow][downCol].IS_WHITE) {
                    // next down two move is empty
                    if (checkBoundaries(doubleDownRow) && checkBoundaries(doubleDownCol)) {
                        return ((Board) board).getFields()[doubleDownRow][doubleDownCol] == null;
                    }
                }
            }
        }
        return false;
    }

    public static Boolean upMultiplyMoves(Object board, int upRow, int upCol, int doubleUpRow, int doubleUpCol){
        // next up move not null
        if (checkBoundaries(upRow) && checkBoundaries(upCol)) {
            if (((Board) board).getFields()[upRow][upCol] != null) {
                // next up move is enemy
                if (((Board) board).getFields()[upRow][upCol].IS_WHITE) {
                    // next up two move is empty
                    if (checkBoundaries(doubleUpRow) && checkBoundaries(doubleUpCol)) {
                        return ((Board) board).getFields()[doubleUpRow][doubleUpCol] == null;
                    }
                }
            }
        }
        return false;
    }

    public static int[] getActualPawnCoordinates(Object board, int startCol, int enemyRow, int enemyCol, Boolean isWhite){
        int[] coordinates = new int[2];
        coordinates[0] = enemyRow;
        coordinates[1] = enemyCol;
        if (checkBoundaries(enemyRow) && checkBoundaries(enemyCol)) {
            if (((Board) board).getFields()[enemyRow-1][enemyCol-1] == null) {
                if (isWhite) {
                    coordinates[0] = enemyRow + 1;
                } else {
                    coordinates[0] = enemyRow - 1;
                }
                if (enemyCol - startCol > 0) {
                    coordinates[1] = enemyCol + 1;
                } else {
                    coordinates[1] = enemyCol - 1;
                }
            }
        }
        return coordinates;
    }


    public static Boolean checkIfMultiplyMoves(Object board, int startCol, int enemyRow, int enemyCol, Boolean isWhite){
        int row = getActualPawnCoordinates(board, startCol, enemyRow, enemyCol, isWhite)[0];
        int col = getActualPawnCoordinates(board, startCol, enemyRow, enemyCol, isWhite)[1];

        // White move
        if (isWhite){
            // left down diagonal move
            if (downMultiplyMoves(board, row, (col-2), (row+1), (col-3))) { return true; }
            // right down diagonal move
            if (downMultiplyMoves(board, row, col, (row+1), (col+1))) { return true; }
            // left and right down diagonal move is empty or own pawns
            return false;
        }

        // Black move
        else {
            // left up diagonal move
            if (upMultiplyMoves(board, (row-2), (col-2), (row-3), (col-3))) { return true; }
            // right up diagonal move
            if (upMultiplyMoves(board, (row-2), col, (row-3), (col+1))) { return true; }
            // left and right up diagonal move is empty or own pawns
            return false;
        }
    }

    public static void checkForWinner(Object board){
        int whitePawnsCounter = 0;
        int blackPawnsCounter = 0;
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (((Board) board).getFields()[i][j] != null) {
                    if (((Board) board).getFields()[i][j].IS_WHITE) {
                        whitePawnsCounter++;
                    } else if (!((Board) board).getFields()[i][j].IS_WHITE) {
                        blackPawnsCounter++;
                    }
                }
            }
        }
        if (whitePawnsCounter == 0) {
            winnerName = player2Name;
        } else if (blackPawnsCounter == 0) {
            winnerName = player1Name;
        }
    }
}
