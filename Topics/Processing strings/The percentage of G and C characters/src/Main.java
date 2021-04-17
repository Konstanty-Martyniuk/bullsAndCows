import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] input = scanner.nextLine().toLowerCase().toCharArray();
        int times = 0;
        for (char i: input) {
            if (i == 'c' || i == 'g') {
                times++;
            }
        }
        System.out.println((double) times / input.length * 100);
    }
}