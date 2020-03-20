package implementation;

import java.util.Scanner;

public class FairRations {

    static void fairRations(int[] b) {
        int people = b.length;
        int give = 0;

        int sum = 0;
        for (int person : b) {
            sum += person;
        }
        if (sum % 2 != 0) {
            System.out.println("NO");
            return;
        }

        for (int i = 0; i < people; i++) {
            if (b[i] % 2 != 0) {
                ++b[i];
                ++b[i + 1];
                give += 2;
            }
        }

        System.out.println(give);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] B = new int[N];

        String[] BItems = scanner.nextLine().split(" ");
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < N; i++) {
            int BItem = Integer.parseInt(BItems[i]);
            B[i] = BItem;
        }

        fairRations(B);

        scanner.close();
    }
}
