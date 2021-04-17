import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String result;
        String word = scanner.nextLine();
        if (word.length() % 2 == 0) {
            result = word.substring(0, word.length() / 2 - 1) + word.substring(word.length() / 2 + 1);
        } else {
            result = word.substring(0, word.length() / 2) + word.substring(word.length() / 2 + 1);
        }
        System.out.println(result);
    }
}