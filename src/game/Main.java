package game;

//import static game.UI.getBoardSize;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();

        String player1Name = "Tom"; //Player.getPlayerName();
        String player2Name = "Jerry"; //Player.getPlayerName();

        Player player1 = new Player(player1Name, true, board.getPlayerPawnsNumber());
        Player player2 = new Player(player2Name, false, board.getPlayerPawnsNumber());

        System.out.println(board);
        if (board.getFields()[2][0] != null) {
            System.out.println(board.getFields()[2][0].getCoordinates());
        }
    }
}
