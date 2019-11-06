package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class FindTheMedian {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) 
            arr[i] = scanner.nextInt();
        System.out.println(findMedian(arr));
    }

    public static int findMedian(int[] arr) {
        Arrays.sort(arr);
        int mid = arr.length/2;
        return arr[mid];
    }
}
