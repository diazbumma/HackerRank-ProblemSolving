package bitmanipulation;

import java.util.Scanner;

public class MaximizingXOR {

    static int maximizingXor(int l, int r) {
        int maxXor = -1;
        for (int i = l; i <= r; i++) {
            for (int j = i; j <= r; j++) {
                int xor = i^j;
                if (xor > maxXor)
                    maxXor = i^j;
            }
        }
        return maxXor;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int l = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int r = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = maximizingXor(l, r);

        System.out.println(result);

        scanner.close();
    }
}
