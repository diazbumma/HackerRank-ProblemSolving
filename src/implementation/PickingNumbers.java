package implementation;

import java.util.Scanner;

public class PickingNumbers {

    static int pickingNumbers(int[] a) {
        int[] freq = new int[100];
        for (int i = 0; i < a.length; i++) {
            freq[a[i]]++;
        }
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < freq.length-1; i++) {
            if (freq[i]+freq[i+1] > maxLength)
                maxLength = freq[i]+freq[i+1];
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int result = pickingNumbers(a);
        System.out.println(result);
        in.close();
    }
}
