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
        boardSize = Board.getBoardSize();
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
            if (((Board) board).getFields()[enemyRow][enemyCol] != null) {
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

    public static void checkForWinner(){
    }

}
