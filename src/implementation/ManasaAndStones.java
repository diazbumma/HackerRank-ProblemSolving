package implementation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ManasaAndStones {

    static Object[] stones(int n, int a, int b) {
        Set<Integer> set = new HashSet<>();

        int n1 = n;
        int n2 = 0;

        while (n2 != n) {
            int temp = ((--n1)*a + (n2++)*b);
            set.add(temp);
        }

        return set.toArray();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int a = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int b = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            Object[] result = stones(n, a, b);
            Arrays.sort(result);

            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i]);

                if (i != result.length - 1) {
                    System.out.print(" ");
                }
            }

            System.out.print("\n");
        }

        scanner.close();
    }
}
