package bitmanipulation;

import java.util.Scanner;

/*
 * but somehow, i don't see any bit manipulation in here
 */
public class LonelyInteger {

    static int lonelyinteger(int[] a) {
        int[] freq = new int[101];
        for (int i = 0; i < a.length; i++) {
            freq[a[i]]++;
        }
        int unique = -1;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 1) {
                unique = i;
                break;
            }
        }
        return unique;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int result = lonelyinteger(a);

        System.out.println(result);

        scanner.close();
    }
}
