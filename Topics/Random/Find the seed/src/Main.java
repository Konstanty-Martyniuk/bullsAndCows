import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // write your code here
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();
        int minMaxSeed = 0;
        int max = 0;
        int min = Integer.MAX_VALUE;

        int[] randomArray = new int[b + 1];

        //Fills the array with the max number from each seed sequence
        for (int i = a; i <= b; i++) {
            Random rand = new Random(i);
            max = 0;
            for (int j = 0; j < n; j++) {
                int ranDom = rand.nextInt(k);
                if (ranDom > max) {
                    max = ranDom;
                    randomArray[i] = max;
                }
            }
        }
        //Find the minimum number and seed
        for (int j = a; j <= b; j++) {
            if (randomArray[j] < min) {
                min = randomArray[j];
                minMaxSeed = j;
            }
        }

        System.out.println(minMaxSeed);
        System.out.println(min);
    }
}