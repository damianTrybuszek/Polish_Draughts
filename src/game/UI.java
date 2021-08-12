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
}
