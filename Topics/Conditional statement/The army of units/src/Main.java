import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number < 1) {
            System.out.println("no army");
        } else if (number < 20) {
            System.out.println("pack");
        } else if (number < 250) {
            System.out.println("throng");
        } else if (number < 1000) {
            System.out.println("zounds");
        } else {
            System.out.println("legion");
        }
    }
}