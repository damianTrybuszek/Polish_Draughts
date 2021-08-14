package game;

//import static game.UI.getBoardSize;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game.start();
        String player1Name = Game.player1Name;
        String player2Name = Game.player2Name;
        int boardSize = Game.boardSize;

        Board board = new Board(boardSize);

        Player player1 = new Player(player1Name, true, board.getPlayerPawnsNumber());
        Player player2 = new Player(player2Name, false, board.getPlayerPawnsNumber());


//        while(TR):
        System.out.println(board);
        int correctMoveCounter = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            String actualMovePlayer = Game.playRound(correctMoveCounter);
            System.out.println(actualMovePlayer + ", Your turn!");
            System.out.println("Provide a number of row of the Pawn, You want to move: ");
            int row = scanner.nextInt();
            System.out.println("Provide a number of column of the Pawn, You want to move: ");
            int col = scanner.nextInt();
            Boolean decisionToStart = Game.tryToMakeMove(board, row, col, true, actualMovePlayer);
            if (decisionToStart){
                System.out.println("Provide a number of row, that you want to move on: ");
                int newRow = scanner.nextInt();
                System.out.println("Provide a number of column that you want to move on: ");
                int newCol = scanner.nextInt();
                Boolean decisionToMove = Game.tryToMakeMove(board, newRow, newCol, false, actualMovePlayer);
                if (decisionToMove){
                    boolean isWhite = board.getFields()[row-1][col-1].IS_WHITE;
                    board.movePawn(row, col, newRow, newCol, isWhite);
                    correctMoveCounter++;
                }
            }
            System.out.println(board);
        } while (correctMoveCounter < 10);


//        if (board.getFields()[2][0] != null) {
//            System.out.println(board.getFields()[2][0].getCoordinates());
//        }

//        testTryToMakeMove(board);
    }

//    public static void testTryToMakeMove(Object board){
//        int correctMoveCounter = 0;
//        Scanner scanner = new Scanner(System.in);
//        do {
//            System.out.println("Provide a number of row: ");
//            int row = scanner.nextInt();
//            System.out.println("Provide a number of column: ");
//            int col = scanner.nextInt();
//            String actualMovePlayer = game.playRound(correctMoveCounter);
//            Boolean decisionToStart = game.tryToMakeMove(board, row, col, true, actualMovePlayer);
//            System.out.println(decisionToStart);
//            System.out.println(board);
//            correctMoveCounter++;
//        } while (correctMoveCounter < 10);
//    }
}
