package game;

import static game.UI.getBoardSize;

public class Main {
    public static void main(String[] args) {
        int boardSize = getBoardSize();
//        int boardSize = 10;
        Board board = new Board(boardSize);
        System.out.println(board);
    }
}
