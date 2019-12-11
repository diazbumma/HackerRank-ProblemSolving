package recursion;

import java.util.Scanner;

public class RecursiveDigitSum {

    static int superDigit(String n, int k) {
        if (n.length() == 1)
            return Integer.parseInt(n);

        long result = 0;
        for (int i = 0; i < n.length(); i++)
            result += (n.charAt(i)-48);
        result *= k;

        return superDigit(String.valueOf(result), 1);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nk = scanner.nextLine().split(" ");

        String n = nk[0];

        int k = Integer.parseInt(nk[1]);

        int result = superDigit(n, k);

        System.out.println(result);

        scanner.close();
    }
}
