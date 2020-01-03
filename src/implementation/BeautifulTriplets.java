package implementation;

import java.util.Scanner;

public class BeautifulTriplets {

    static int beautifulTriplets(int d, int[] arr) {
        int beautiful = 0;
        int end = arr.length-1;

        for (int i = end; i >= 2; i--) {
            int triplet = 0;
            int j = i-1;
            int value = arr[i];

            while (triplet < 2 && j >= 0 && arr[j] >= (value-d)) {
                if (value-arr[j] == d) {
                    value = arr[j];
                    ++triplet;
                }
                --j;
            }

            if (triplet == 2)
                ++beautiful;
        }

        return beautiful;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = beautifulTriplets(d, arr);

        System.out.println(result);

        scanner.close();
    }
}
