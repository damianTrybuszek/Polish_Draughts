package game;

//import static game.UI.getBoardSize;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        game.start();
        String player1Name = game.player1Name;
        String player2Name = game.player2Name;
        int boardSize = game.boardSize;
//        int boardSize = 10;


        Board board = new Board(boardSize);

        Player player1 = new Player(player1Name, true, board.getPlayerPawnsNumber());
        Player player2 = new Player(player2Name, false, board.getPlayerPawnsNumber());


        System.out.println(board);
        if (board.getFields()[2][0] != null) {
            System.out.println(board.getFields()[2][0].getCoordinates());
        }

        testTryToMakeMove(board);
    }

    public static void testTryToMakeMove(Object board){
        int correctMoveCounter = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Provide a number of row: ");
            int row = scanner.nextInt();
            System.out.println("Provide a number of column: ");
            int col = scanner.nextInt();
            String actualMovePlayer = game.playRound(correctMoveCounter);
            Boolean decisionToStart = game.tryToMakeMove(board, row, col, true, actualMovePlayer);
            System.out.println(decisionToStart);
            System.out.println(board);
            correctMoveCounter++;
        } while (correctMoveCounter < 10);
    }
}
