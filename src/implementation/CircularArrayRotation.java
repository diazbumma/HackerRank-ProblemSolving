package implementation;

import java.util.Scanner;

public class CircularArrayRotation {

//    sample test case
//    3 2 3
//    1 2 3
//    0
//    1
//    2

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int q = scanner.nextInt();
        int[] intArray = new int[n];
        int[] queries = new int[q];
        for (int i=0; i<n; i++)
            intArray[i] = scanner.nextInt();
        for (int i=0; i<q; i++)
            queries[i] = scanner.nextInt();
        int[] result = circularArrayRotation(intArray, k, queries);
        for (int i=0; i<q; i++)
            System.out.println(result[i]);
        scanner.close();
    }

    public static int[] circularArrayRotation(int[] a, int k, int[] queries) {
        int[] report = new int[a.length];
        int rotate = k%a.length;
        for (int i=0; i<a.length; i++) {
            int indeks = (i%a.length)-rotate;
            if (indeks < 0)
                indeks += a.length;
            report[i] = a[indeks];
        }
        int[] result = new int[queries.length];
        for (int i=0; i<queries.length; i++) {
            result[i] = report[queries[i]];
        }
        return result;
    }
}
