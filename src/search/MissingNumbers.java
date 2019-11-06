package search;

import java.util.ArrayList;
import java.util.Scanner;

public class MissingNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nArr = scanner.nextInt();
        int[] arr = new int[nArr];
        for (int i = 0; i < nArr; i++)
            arr[i] = scanner.nextInt();
        int nBrr = scanner.nextInt();
        int[] brr = new int[nBrr];
        for (int i = 0; i < nBrr; i++)
            brr[i] = scanner.nextInt();
        for (int val : missingNumbers(arr, brr))
            System.out.print(val + " ");
    }

    public static int[] missingNumbers(int[] arr, int[] brr) {
        int[] freq = new int[10000];
        for (int i = 0; i < brr.length; i++)
            freq[brr[i]]++;
        for (int i = 0; i < arr.length; i++)
            freq[arr[i]]--;
        ArrayList<Integer> miss = new ArrayList<>();
        for (int i = 0; i < freq.length; i++)
            if (freq[i]>0)
                miss.add(i);
        int[] missCopy = new int[miss.size()];
        for (int i = 0; i < miss.size(); i++)
            missCopy[i] = miss.get(i);
        return missCopy;
    }
}
