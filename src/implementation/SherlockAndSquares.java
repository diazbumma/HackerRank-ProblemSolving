package implementation;

import java.util.Scanner;

public class SherlockAndSquares {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(squares(a, b));
        }
    }

    public static int squares(int a, int b) {
        double squareRoot = Math.sqrt(a);
        int lower;
        if (squareRoot%1 != 0.0)
            lower = ((int) squareRoot)+1;
        else
            lower = (int) squareRoot;
        int squareCount = 0;
        while (Math.pow(lower, 2) <= b) {
            squareCount++;
            lower++;
        }
        return squareCount;
    }
}
