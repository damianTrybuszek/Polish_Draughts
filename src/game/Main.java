package game;

//import static game.UI.getBoardSize;

public class Main {
    public static void main(String[] args) {
//        int boardSize = getBoardSize();
        int boardSize = 10;
        Board board = new Board(boardSize);

        String player1Name = "Tom"; //Player.getPlayerName();
        String player2Name = "Jerry"; //Player.getPlayerName();

        Player player1 = new Player(player1Name, true,/*, 'W'*/board.getPlayerPawnsNumber());
        Player player2 = new Player(player2Name, false,/*, 'B'*/board.getPlayerPawnsNumber());

        System.out.println(board);

    }
}
