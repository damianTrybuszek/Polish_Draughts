package game;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class UI {

    public static int getBoardSize() {
        Scanner scanner = new Scanner(System.in);
        AtomicInteger boardSize = new AtomicInteger(-1);
        do {
            //todo: clear console here
            printComunicate("Please provide a board size from 10 to 20");
            boardSize.set(scanner.nextInt());
        } while (boardSize.get() < 10 || boardSize.get() > 20);
        return boardSize.get();
    }

    public static void printComunicate(String comunicate) {
        System.out.println(Colors.ANSI_CYAN + "*   *   *" + Colors.ANSI_WHITE);
        System.out.println(comunicate);
        System.out.println(Colors.ANSI_CYAN + "*   *   *" + Colors.ANSI_WHITE);
    }
}
