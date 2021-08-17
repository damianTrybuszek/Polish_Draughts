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
        boolean fightStatus = false;
        Scanner scanner = new Scanner(System.in);
        do {
            String actualMovePlayer = Game.playRound(correctMoveCounter);
            System.out.println(actualMovePlayer + ", Your turn!");
            System.out.println("Provide a number of row of the Pawn, You want to move: ");
            int row = scanner.nextInt();
            System.out.println("Provide a number of column of the Pawn, You want to move: ");
            int col = scanner.nextInt();
            Boolean decisionToStart = Game.tryToMakeMove(board, row, col, true, actualMovePlayer, 0, 0);
            if (decisionToStart) {
                System.out.println("Provide a number of row, that you want to move on: ");
                int newRow = scanner.nextInt();
                System.out.println("Provide a number of column that you want to move on: ");
                int newCol = scanner.nextInt();
                Boolean decisionToMove = Game.tryToMakeMove(board, row, col, false, actualMovePlayer, newRow, newCol);
                if (decisionToMove) {
                    if (board.getFields()[newRow - 1][newCol - 1] != null) {
                        fightStatus = true;
                    }
                    boolean isWhite = board.getFields()[row - 1][col - 1].IS_WHITE;
                    board.movePawn(row, col, newRow, newCol, isWhite);
                    if (fightStatus) {
                        System.out.println(board);
                        while (Game.checkIfMultiplyMoves(board, col, newRow, newCol, isWhite)){
                            board.multiplyMovePawn(board, actualMovePlayer, isWhite);
                        }
                    }
                    fightStatus = false;
                    correctMoveCounter++;
                }
            }
            System.out.println(board);
        } while (correctMoveCounter < 40);
    }
}
