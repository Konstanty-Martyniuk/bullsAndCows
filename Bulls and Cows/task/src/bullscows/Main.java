package bullscows;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Prepare game
        int number = 0;
        int range = 0;
        System.out.println("Input the length of the secret code:");
        if (scanner.hasNextInt()) {
            number = scanner.nextInt();
        } else {
            System.out.println("Error: it is not a valid number.");
            return;
        }
        System.out.println("Input the number of possible symbols in the code:");
        if (scanner.hasNextInt()) {
            range = scanner.nextInt();
        } else {
            System.out.println("Error: it is not a valid number.");
            return;
        }
        if (number > range || number == 0) {
            System.out.println("Error: it's not possible to generate a code with a length of "
                    + number + " with " + range + " unique symbols.");
            return;
        }
        if (range > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            return;
        }

        System.out.print("The secret is prepared: ");
        System.out.print("*".repeat(number));
        System.out.println(" (0-" + (range < 10 ? range + ")" : "9, a-" + (char) (86 + range) + ")."));
        String secretCode = randomGenerator(number, range);
        System.out.println("Okay, let's start a game!");
        int turn = 0;
        //Game loop
        do {
            scanner = new Scanner(System.in);
            System.out.println("Turn " + ++turn + ":");
            char[] userInput = scanner.nextLine().toCharArray();
            int length = secretCode.length();
            int bulls = 0;
            int cows = 0;
            //calculate cows and bulls
            for (int i = 0; i < length; i++) {
                if (secretCode.indexOf(userInput[i]) == i) {
                    bulls++;
                } else if (secretCode.indexOf(userInput[i]) > -1) {
                    cows++;
                }
            }
            //create message for user
            if (checkUserInput(length, bulls, cows)) return;
        } while (true);
    }

    public static boolean checkUserInput(int length, int bulls, int cows) {
        if (bulls == length){
            System.out.println("Grade: " + pluralizeResult("bull", bulls));
            System.out.println("Congratulations! You guessed the secret code.");
            return true;
        }
        if (cows > 0 && bulls > 0) {
            System.out.println("Grade: " + pluralizeResult("bull", bulls) + " and " + pluralizeResult("cow", cows));
            }
        if (bulls > 0) {
            System.out.println("Grade: " + pluralizeResult("bull", bulls));
        } else if (cows > 0) {
            System.out.println("Grade: " + pluralizeResult("cow", cows));
        } else {
            System.out.println("Cannot find number of bulls or number of cows or None after the input.");
        }
        return false;
    }

    public static String randomGenerator(int length, int range) {
        String result = "Error: can't generate a secret number with a length of "
                + length + " because there aren't enough unique digits.";
        if (length > 10) {
            return result;
        } else {
            StringBuilder sb = new StringBuilder();
            List<String> randomList = Arrays.asList(("0123456789abcdefghijklmnopqrstuvwxyz".split("")));
            List<String>  sublist = randomList.subList(0, range);
            Collections.shuffle(sublist);
            for (int i = 0; i < length; i++) {
                sb.append(sublist.get(i));
            }
            result = sb.reverse().toString();
        }
        return result;
    }

    public static String pluralizeResult(String word, int quantity) {
        StringBuilder sb = new StringBuilder();
        sb.append(quantity).append(" ").append(word);
        if (quantity > 1) {
            sb.append("s");
        }
        return String.valueOf(sb);
    }
}