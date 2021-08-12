package game;

//import static game.UI.getBoardSize;
import static game.Colors.*;
public class Main {
    public static void main(String[] args) {
        int boardSize = Board.getBoardSize();
//        int boardSize = 10;
        Board board = new Board(boardSize);

        String player1Name = "Tom"; //Player.getPlayerName();
        String player2Name = "Jerry"; //Player.getPlayerName();

        Player player1 = new Player(player1Name, true,/*, 'W'*/board.getPlayerPawnsNumber());
        Player player2 = new Player(player2Name, false,/*, 'B'*/board.getPlayerPawnsNumber());

        System.out.println(board);

        //● ◌ ☼ ᴑ ۝ ۞ ֎ ҉ ҈ ѻ


//        System.out.println("\t\t***Regular Colors***");
//        System.out.println(BLACK + "test ANSI_RESET");
//        System.out.println(RED + "test ANSI_BLACK");
//        System.out.println(GREEN + "test ANSI_RED");
//        System.out.println(YELLOW + "test ANSI_GREEN");
//        System.out.println(BLUE + "test ANSI_YELLOW");
//        System.out.println(PURPLE + "test ANSI_BLUE");
//        System.out.println(CYAN + "test ANSI_PURPLE");
//        System.out.println(WHITE + "test ANSI_CYAN");
//
//        System.out.println("\t\t***Bold***");
//        System.out.println(BLACK_BOLD + "test ANSI_BLACK_BACKGROUND");
//        System.out.println(RED_BOLD + "test ANSI_RED_BACKGROUND");
//        System.out.println(GREEN_BOLD + "test ANSI_GREEN_BACKGROUND");
//        System.out.println(YELLOW_BOLD + "test ANSI_YELLOW_BACKGROUND");
//        System.out.println(BLUE_BOLD + "test ANSI_BLUE_BACKGROUND");
//        System.out.println(PURPLE_BOLD + "test ANSI_PURPLE_BACKGROUND");
//        System.out.println(CYAN_BOLD + "test ANSI_CYAN_BACKGROUND");
//        System.out.println(WHITE_BOLD + "test ANSI_WHITE_BACKGROUND");

        System.out.println(Colors.RESET);
        System.out.print(CYAN + BLACK_BACKGROUND + "   ");
        System.out.print(CYAN + WHITE_BACKGROUND + "   ");
        System.out.print(CYAN + BLACK_BACKGROUND + "   ");
        System.out.print(CYAN + WHITE_BACKGROUND + "   ");
        System.out.print(CYAN + BLACK_BACKGROUND + "   ");
        System.out.print(CYAN + WHITE_BACKGROUND + "   ");
        System.out.print(CYAN + BLACK_BACKGROUND + "   ");
        System.out.print(CYAN + WHITE_BACKGROUND + "   ");
        System.out.print(CYAN + BLACK_BACKGROUND + "   ");
        System.out.println(Colors.RESET);
        System.out.print(RED + WHITE_BACKGROUND + "   ");
        System.out.print(RED + BLACK_BACKGROUND + " ● ");
        System.out.print(RED + WHITE_BACKGROUND + "   ");
        System.out.print(RED + BLACK_BACKGROUND + " ● ");
        System.out.print(RED + WHITE_BACKGROUND + "   ");
        System.out.print(RED + BLACK_BACKGROUND + "   ");
        System.out.print(RED + WHITE_BACKGROUND + "   ");
        System.out.print(RED + BLACK_BACKGROUND + " ● ");
        System.out.print(RED + WHITE_BACKGROUND + "   ");
        System.out.println(Colors.RESET);
        System.out.print(CYAN + BLACK_BACKGROUND + " ● ");
        System.out.print(CYAN + WHITE_BACKGROUND + "   ");
        System.out.print(CYAN + BLACK_BACKGROUND + "   ");
        System.out.print(CYAN + WHITE_BACKGROUND + "   ");
        System.out.print(CYAN + BLACK_BACKGROUND + " ● ");
        System.out.print(CYAN + WHITE_BACKGROUND + "   ");
        System.out.print(CYAN + BLACK_BACKGROUND + " ● ");
        System.out.print(CYAN + WHITE_BACKGROUND + "   ");
        System.out.print(CYAN + BLACK_BACKGROUND + "   ");
        System.out.println(Colors.RESET);
        System.out.print(RED + WHITE_BACKGROUND + "   ");
        System.out.print(RED + BLACK_BACKGROUND + "   ");
        System.out.print(RED + WHITE_BACKGROUND + "   ");
        System.out.print(RED + BLACK_BACKGROUND + "   ");
        System.out.print(RED + WHITE_BACKGROUND + "   ");
        System.out.print(RED + BLACK_BACKGROUND + "   ");
        System.out.print(RED + WHITE_BACKGROUND + "   ");
        System.out.print(RED + BLACK_BACKGROUND + "   ");
        System.out.print(RED + WHITE_BACKGROUND + "   ");

    }
}
