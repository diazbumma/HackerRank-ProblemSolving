package implementation;

import java.util.Scanner;

public class LisasWorkbook {

    static int workbook(int n, int k, int[] arr) {
        int iPage = 1;
        int contains;
        int specialProblems = 0;

        for (int i = 0; i < arr.length; i++) {
            contains = k;
            for (int j = 1; j <= arr[i]; j++) {
                if (j > contains) {
                    iPage++;
                    contains += k;
                }
                if (j == iPage)
                    specialProblems++;
            }
            iPage++;
        }

        return specialProblems;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = workbook(n, k, arr);
        System.out.println(result);

        scanner.close();
    }
}
