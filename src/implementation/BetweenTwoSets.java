package implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Result {

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int[] freq = new int[101];
        int temp = a.get(a.size()-1);
        while (temp <= b.get(0)) {
            freq[temp]++;
            temp += a.get(a.size()-1);
        }
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                for (int j = 0; j < a.size()-1; j++) {
                    if (i%a.get(j) != 0) {
                        freq[i] = 0;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                for (int j = 0; j < b.size(); j++) {
                    if (b.get(j)%i != 0) {
                        freq[i] = 0;
                        break;
                    }
                }
            }
        }
        List<Integer> between = new ArrayList<>();
        for (int i = 0; i < freq.length; i++)
            if (freq[i] != 0)
                between.add(i);
        return between.size();
    }
}

public class BetweenTwoSets {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<Integer> arr = new ArrayList<>();
        List<Integer> brr = new ArrayList<>();
        for (int i = 0; i < n; i++)
            arr.add(scanner.nextInt());
        for (int i = 0; i < m; i++)
            brr.add(scanner.nextInt());
        int total = Result.getTotalX(arr, brr);
        System.out.println(total);
    }
}
