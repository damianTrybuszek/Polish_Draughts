package game;

public class Main {
    public static void main(String[] args) {
        int correctMoveCounter = 0;
        boolean fightStatus = false;

        Game.start();
        int boardSize = Game.boardSize;
        Board board = new Board(boardSize);
        System.out.println(board);
        do {
            String actualMovePlayer = Game.playRound(correctMoveCounter);
            System.out.println(actualMovePlayer + ", Your turn!");
            int[] movePawnCoordinates = UI.pawnToMoveCoordinates(1);
            int row = movePawnCoordinates[0];
            int col = movePawnCoordinates[1];
            Boolean decisionToStart = Game.tryToMakeMove(board, row, col, true, actualMovePlayer, 0, 0);
            if (decisionToStart) {
                int[] moveOnPawnCoordinates = UI.pawnToMoveCoordinates(2);
                int newRow = moveOnPawnCoordinates[0];
                int newCol = moveOnPawnCoordinates[1];
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
        } while (Game.winnerName.isBlank());
    }
}
