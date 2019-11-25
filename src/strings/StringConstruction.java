package strings;

import java.util.Scanner;

public class StringConstruction {

    static long stringConstruction(String s) {
        return s.chars().distinct().count();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();
            long result = stringConstruction(s);
            System.out.println(result);
        }
        scanner.close();
    }
}
