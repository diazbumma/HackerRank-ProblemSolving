package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumAbsoluteDifferenceInAnArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();
        System.out.println(minimumAbsoluteDifference(arr));
    }

    public static int minimumAbsoluteDifference(int[] arr) {
        Arrays.sort(arr);
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length-1; i++) {
            int temp = Math.abs(arr[i] - arr[i+1]);
            if (temp < smallest)
                smallest = temp;
        }
        return smallest;
    }
}
