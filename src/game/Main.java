package game;

//import static game.UI.getBoardSize;

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
                Boolean ifNotToFar = Game.checkIfNotTooFar(row, col, newRow, newCol);
                if (decisionToMove && ifNotToFar){
                    boolean isWhite = board.getFields()[row-1][col-1].IS_WHITE;
                    board.movePawn(row, col, newRow, newCol, isWhite);
                    System.out.println(board);
                    // while Game.checkIfMultiplyMoves(board, newRow, newCol, isWhite); { move }
                    Game.checkIfMultiplyMoves(board, col, newRow, newCol, isWhite);
                    correctMoveCounter++;
                }
            }
            System.out.println(board);
        } while (correctMoveCounter < 10);

    }
}
