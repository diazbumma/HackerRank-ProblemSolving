package sorting;

import java.util.Scanner;

public class QuickSort1Partition {
    
    static int[] quickSort(int[] arr) {
        int pivot = arr[0];
        int i = 0;
        int j = arr.length;

        while (i < j) {
            while (i < j && arr[--j] >= pivot);
            if (i < j) {
                arr[i] = arr[j];
            }

            while (i < j && arr[++i] <= pivot);
            if (i < j) {
                arr[j] = arr[i];
            }
        }

        arr[j] = pivot;

        return arr;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = quickSort(arr);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);

            if (i != result.length - 1) {
                System.out.print(" ");
            }
        }

        System.out.print("\n");

        scanner.close();
    }
}
