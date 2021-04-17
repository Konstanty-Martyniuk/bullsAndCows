import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String specialChars = "#$%&'()*+,-.";
        //settings for password
        int[] settings = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        char[] password = new char[settings[3]];
        for (int i = 0; i < settings[3]; i++) {
            int max = 25;
            int min = 1;
            int max1 = 9;
            //uppercase
            if (i < settings[0]) {
                if (i % 2 == 0) {
                    password[i] = alphabet.charAt((int) Math.floor(Math.random() * (max - max / 2 + 1) + max / 2));
                } else {
                    password[i] = alphabet.charAt((int) Math.floor(Math.random() * (max / 2 - 1 - min + 1) + min));
                }
                //lowercase
            } else if (i >= settings[0] && i < settings[0] + settings[1]) {
                if (i % 2 == 0) {
                    password[i] = alphabet.toLowerCase().charAt(
                            (int) Math.floor(Math.random() * (max - max / 2 + 1) + max / 2));
                } else {
                    password[i] = alphabet.toLowerCase().charAt(
                            (int) Math.floor(Math.random() * (max / 2 - 1 - min + 1) + min));
                }
            } else if (i >= settings[0] + settings[1]) {
                if (i % 2 == 0) {
                    password[i] = numbers.charAt((int) Math.floor(Math.random() * (max1 - max1 / 2 + 1) + max1 / 2));
                } else {
                    password[i] = numbers.charAt((int) Math.floor(Math.random() * (max1 / 2 - 1 - min + 1) + min));
                }
            } else {
                password[i] = specialChars.charAt(random.nextInt(specialChars.length()));
            }

        }
        System.out.println(String.valueOf(password));
    }
}