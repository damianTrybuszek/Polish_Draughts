package game;

import java.util.Scanner;

public class UI {

    public static void printStatement(String statement) {
        System.out.println(Colors.CYAN + "*   *   *" + Colors.WHITE);
        System.out.println(Colors.PURPLE + statement);
    }

    public static void printAnotherStatement(String statement) {
        System.out.println(Colors.CYAN + "*   *   *" + Colors.WHITE);
        System.out.println(Colors.PURPLE + statement);
        System.out.println(Colors.CYAN + "*   *   *" + Colors.WHITE);
    }

    public static boolean checkIfString(String name) {
        for (int i = 0; i < name.length(); i++){
            if (Character.isAlphabetic(name.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void clearConsoleScreen() {
//        TODO this method! It doesn't works
//        try {
//            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
//        }
//        catch (Exception e) {
//            System.out.println("Dupa wyszła");
//        }
//        System.out.println("Everything on the console will cleared");
//        System.out.print("\033[H\033[2J");
//        System.out.flush();
    }

    public static String stringBuilder(String stringToChange, String stringToInsert, int offset) {
        StringBuilder statement = new StringBuilder(stringToChange);
        statement.insert(offset, stringToInsert);
        return statement.toString();
    }

    public static int[] pawnToMoveCoordinates(int option){
        String endOfSentence;
        int[] coordinates = new int[2];
        Scanner scanner = new Scanner(System.in);
        switch (option){
            case 1: endOfSentence = " of the Pawn, You want to move: "; break;
            case 2: endOfSentence = ", that you want to move on: "; break;
            default:
                throw new IllegalStateException("Unexpected value: " + option);
        }
        System.out.println("Provide a number of row" + endOfSentence);
        coordinates[0] = scanner.nextInt();
        System.out.println("Provide a number of column" + endOfSentence);
        coordinates[1] = scanner.nextInt();
        return coordinates;
    }
}
