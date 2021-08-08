package game;

public class Board {
    private final int BOARD_SIZE;
    private final int PLAYER_STARTING_PAWNS_NUMBER;
    private final Pawn[][] fields;//final?

    public Board(int size) {
        this.BOARD_SIZE = size;
        this.PLAYER_STARTING_PAWNS_NUMBER = size * 2;
        this.fields = new Pawn[size][size];
        this.boardInit();
    }

    protected void boardInit() {
        //whites
        for (int i = 0; i < BOARD_SIZE / 2 - 1; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        fields[i][j] = new Pawn(true, false);
                    }
                } else {
                    if (j % 2 == 1) {
                        fields[i][j] = new Pawn(true, false);
                    }
                }
            }
        }
        //blacks
        for (int i = BOARD_SIZE - 1; i > BOARD_SIZE / 2; i--) {
            for (int j = BOARD_SIZE - 1; j >= 0; j--) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        fields[i][j] = new Pawn(false, false);
                    }
                } else {
                    if (j % 2 == 1) {
                        fields[i][j] = new Pawn(false, false);
                    }
                }
            }
        }
    }

    public String toString() {
        StringBuilder boardString = new StringBuilder();
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (fields[i][j] != null) {
                    boardString.append(" ").append(fields[i][j].getIndicatorChar()).append(" ");
                } else {
                    boardString.append(" # ");
                }
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }

    public int getBOARD_SIZE() {
        return BOARD_SIZE;
    }

    public int getPlayerPawnsNumber() {
        return PLAYER_STARTING_PAWNS_NUMBER;
    }

    public Pawn[][] getFields() {
        return fields;
    }

    public void removePawn() {
    }

    public void movePawn() {
    }

}
