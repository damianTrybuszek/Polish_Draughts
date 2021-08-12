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
        this.boardInit();
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

    protected void boardInit() {
        initWhitePawns();
        initBlackPawns();
    }

    private void initWhitePawns() {
        for (int i = 0; i < BOARD_SIZE / 2 - 1; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        FIELDS[i][j] = new Pawn(true, false);
                    }
                } else {
                    if (j % 2 == 1) {
                        FIELDS[i][j] = new Pawn(true, false);
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
                        FIELDS[i][j] = new Pawn(false, false);
                    }
                } else {
                    if (j % 2 == 1) {
                        FIELDS[i][j] = new Pawn(false, false);
                    }
                }
            }
        }
    }

    public String toString() {
        StringBuilder boardString = new StringBuilder();
        String fieldColor;
        for (int i = 0; i < BOARD_SIZE; i++) { //board row
            for (int j = 0; j < BOARD_SIZE; j++) { //board column
                if ((j + i) % 2 == 0) {
                    fieldColor = BLACK_BACKGROUND;
                } else {
                    fieldColor = WHITE_BACKGROUND;
                }
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
            boardString.append("\n");
        }
        return boardString.toString();
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

    public void removePawn() {
    }

    public void movePawn() {
    }

}
