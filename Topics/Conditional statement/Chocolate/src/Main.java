import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int width = scanner.nextInt();
        int numberOfSegments = scanner.nextInt();

        if (length * width > numberOfSegments && (numberOfSegments % length == 0 || numberOfSegments % width == 0)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}