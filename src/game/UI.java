package game;

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
}
