package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class PermutingTwoArrays {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int j = 0; j < n; j++)
                a[j] = scanner.nextInt();
            for (int j = 0; j < n; j++)
                b[j] = scanner.nextInt();
            System.out.println(twoArrays(k, a, b));
        }
    }

    public static String twoArrays(int k, int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int j = B.length-1;
        for (int i = 0; i < A.length; i++) {
            while (j >= 0) {
                if (A[i]+B[j] >= k) {
                    j--;
                    break;
                }
                j--;
            }
            if (j<0 && i!=A.length-1)
                return "NO";
        }
        return "YES";
    }
}
