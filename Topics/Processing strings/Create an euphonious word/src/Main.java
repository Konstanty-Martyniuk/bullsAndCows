import java.util.*;

public class Main {
    public static void main(String[] args) {
        String vowels = "aeiouy";
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        char[] word = scanner.nextLine().toLowerCase().toCharArray();
        //convert all vowels to 'v', and consonants to 'c'
        for (int i = 0; i < word.length; i++) {
            if (vowels.indexOf(word[i]) == -1) {
                word[i] = 'c';
            } else {
                word[i] = 'v';
            }
        }
        //check if 3 'v' or 'c' are in a row. If true, than increment by 1 `count` and i. We have to check
        //if last digit create one more "3 in a row".
        for (int i = 0; i < word.length - 2; i++) {
            if (word[i] == word[i + 1] && word[i + 1] == word[i + 2]) {
                count++;
                i++;
            }
        }
        System.out.println(count);
    }
}