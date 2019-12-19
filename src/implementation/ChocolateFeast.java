package implementation;

import java.util.Scanner;

public class ChocolateFeast {

    static int chocolateFeast(int n, int c, int m) {
        int chocolate = n/c;
        int freeChocolate = chocolate/m;
        int remainWrapper = chocolate%m;
        int totalChocolate = chocolate + freeChocolate;

        while (freeChocolate+remainWrapper >= m) {
            chocolate = freeChocolate+remainWrapper;
            freeChocolate = chocolate / m;
            remainWrapper = chocolate % m;
            totalChocolate += freeChocolate;
        }

        return totalChocolate;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {

            int n = scanner.nextInt();

            int c = scanner.nextInt();

            int m = scanner.nextInt();

            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = chocolateFeast(n, c, m);

            System.out.println(result);
        }

        scanner.close();
    }
}
