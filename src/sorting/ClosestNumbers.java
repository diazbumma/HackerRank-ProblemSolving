package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ClosestNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();
        int[] result = closestNumbers(arr);
        for (int i = 0; i < result.length; i++) {
            if (i != result.length-1)
                System.out.print(result[i] + " ");
            else
                System.out.print(result[i]);
        }
    }

    public static int[] closestNumbers(int[] arr) {
        Arrays.sort(arr);
        List<Integer> closest = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i+1]-arr[i] < minDiff) {
                closest.clear();
                minDiff = arr[i+1]-arr[i];
            }
            if (arr[i+1]-arr[i] == minDiff) {
                closest.add(arr[i]);
                closest.add(arr[i+1]);
            }
        }
        int[] result = new int[closest.size()];
        for (int i = 0; i < closest.size(); i++)
            result[i] = closest.get(i);
        return result;
    }
}
