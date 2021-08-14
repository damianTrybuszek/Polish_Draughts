package game;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import static game.Colors.*;

public class Board {
    private final static int MINIMUM_BOARD_SIZE = 10;
    private final static int MAXIMUM_BOARD_SIZE = 20;
    private final int BOARD_SIZE;
    private final int PLAYER_STARTING_PAWNS_NUMBER;
    private final Pawn[][] FIELDS;//final?

    public Board(int size) {
        this.BOARD_SIZE = size;
        this.PLAYER_STARTING_PAWNS_NUMBER = size * 2;
        this.FIELDS = new Pawn[size][size];
        this.initPawns();
    }

    public static int getBoardSize() {
        Scanner scanner = new Scanner(System.in);
        AtomicInteger boardSize = new AtomicInteger(-1);
        do {
            //todo: clear console here
            UI.printStatement("Please provide a board size from 10 to 20");
            boardSize.set(scanner.nextInt());
        } while (boardSize.get() < MINIMUM_BOARD_SIZE || boardSize.get() > MAXIMUM_BOARD_SIZE);
        return boardSize.get();
    }

    protected void initPawns() {
        initWhitePawns();
        initBlackPawns();
    }

    private void initWhitePawns() {
        for (int i = 0; i < BOARD_SIZE / 2 - 1; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        FIELDS[i][j] = new Pawn(true, false, i, j);
                    }
                } else {
                    if (j % 2 == 1) {
                        FIELDS[i][j] = new Pawn(true, false, i, j);
                    }
                }
            }
        }
    }

    private void initBlackPawns() {
        for (int i = BOARD_SIZE - 1; i > BOARD_SIZE / 2; i--) {
            for (int j = BOARD_SIZE - 1; j >= 0; j--) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        FIELDS[i][j] = new Pawn(false, false, i, j);
                    }
                } else {
                    if (j % 2 == 1) {
                        FIELDS[i][j] = new Pawn(false, false, i, j);
                    }
                }
            }
        }
    }

    public String toString() {
        StringBuilder boardString = new StringBuilder();
        printBoardJCoordinates(boardString);
        String fieldColor;
        for (int i = 0; i < BOARD_SIZE; i++) { //board column
            if (i < 9) {
                boardString.append(' ').append(i + 1).append(' ');
            } else {
                boardString.append(i + 1).append(' ');
            }
            for (int j = 0; j < BOARD_SIZE; j++) { //board row
                if ((j + i) % 2 == 0)  {
                    fieldColor = BLACK_BACKGROUND;
                } else {
                    fieldColor = WHITE_BACKGROUND;
                }
                printField(boardString, fieldColor, i, j);
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }

    private void printField(StringBuilder boardString, String fieldColor, int i, int j) {
        if (FIELDS[i][j] != null) {
            String pawnColor;
            if (FIELDS[i][j].isIS_WHITE()) {
                pawnColor = Colors.BLUE;
            } else {
                pawnColor = Colors.RED;
            }
            boardString.append(fieldColor).append(" ").append(pawnColor + fieldColor).append(FIELDS[i][j].getPawnSymbol()).append(fieldColor).append(" ").append(RESET);
        } else {
            boardString.append(fieldColor).append("   ").append(Colors.RESET);
        }
    }

    private void printBoardJCoordinates(StringBuilder boardString) {
        boardString.append("   ");
        for (int j = 1; j < BOARD_SIZE + 1; j++) {
            if (j < 9) {
                boardString.append(' ').append(j).append(' ');
            } else {
                boardString.append(' ').append(j);
            }
        }
        boardString.append("\n");
    }

    public int getBoard_Size() {
        return BOARD_SIZE;
    }

    public int getPlayerPawnsNumber() {
        return PLAYER_STARTING_PAWNS_NUMBER;
    }

    public Pawn[][] getFields() {
        return FIELDS;
    }

    public void removePawn(int row, int col) {
        FIELDS[row-1][col-1] = null;

    }

    public void movePawn(int row, int col, int newRow, int newCol, boolean isWhite) {
        removePawn(row, col);
        int rowDiff = newRow - row;
        int colDiff = newCol - col;
        if(FIELDS[newRow-1][newCol-1] == null) {
            if (isWhite) {
                FIELDS[newRow - 1][newCol - 1] = new Pawn(true, false, newRow, newCol);
            } else {
                FIELDS[newRow - 1][newCol - 1] = new Pawn(false, false, newRow, newCol);
            }}
        else if((FIELDS[newRow-1][newCol-1]).IS_WHITE!= isWhite){
            removePawn(newRow, newCol);
            if (isWhite) {
                FIELDS[newRow - 1 + rowDiff][newCol - 1 + colDiff] = new Pawn(true, false, newRow, newCol);
            } else {
                FIELDS[newRow - 1 + rowDiff][newCol - 1 + colDiff] = new Pawn(false, false, newRow, newCol);
            }

        }

    }
}
