package game;

//import static game.UI.getBoardSize;

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

        System.out.println(player1);

        System.out.println(board);
        if (board.getFields()[2][0] != null) {
            System.out.println(board.getFields()[2][0].getCoordinates());
        }

//        int correctMoveCounter = 0;
//        do {
//            game.playRound(correctMoveCounter);
//            correctMoveCounter++;
//        } while (correctMoveCounter < 10);
    }
}
