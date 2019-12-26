package implementation;

import java.util.Scanner;

public class ModifiedKaprekarNumbers {

    static boolean isKaprekarNumber(int n) {
        if (n == 1)
            return true;

        String nString = String.valueOf(n);
        String nSquare = String.valueOf((long) Math.pow(n, 2));

        int d = (nSquare.length())/2;

        String[] split = new String[2];
        split[0] = nSquare.substring(0, d);
        split[1] = nSquare.substring(d);

        for (int i = 0; i < split.length; i++) {
            if (split[i].length() == 0)
                split[i] = "0";
        }

        int[] number = new int[2];
        number[0] = Integer.parseInt(split[0]);
        number[1] = Integer.parseInt(split[1]);

        int sum = -1;

        if (number[0]!=0 && number[1]!=0)
            sum = number[0] + number[1];

        return nString.equals(String.valueOf(sum));
    }

    static void kaprekarNumbers(int p, int q) {
        boolean hasKaprekar = false;

        for (int i = p; i <= q; i++) {
            if (isKaprekarNumber(i)) {
                hasKaprekar = true;
                System.out.print(i + " ");
            }
        }

        if (!hasKaprekar)
            System.out.println("INVALID RANGE");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        kaprekarNumbers(p, q);

        scanner.close();
    }
}
