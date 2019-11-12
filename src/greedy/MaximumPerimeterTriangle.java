package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumPerimeterTriangle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] sticks = new int[n];
        for (int i = 0; i < n; i++)
            sticks[i] = scanner.nextInt();
        int[] result = maximumPerimeterTriangle(sticks);
        for (int i = 0; i < result.length; i++) {
            if (i != result.length-1)
                System.out.print(result[i] + " ");
            else
                System.out.print(result[i] + "\n");
        }
    }

    public static int[] maximumPerimeterTriangle(int[] sticks) {
        Arrays.sort(sticks);
        int longestPerimeter = Integer.MIN_VALUE;
        int[] triangle = new int[3];
        int[] noTriangle = {-1};
        for (int i = 0; i < sticks.length-2; i++) {
            if (sticks[i]+sticks[i+1]>sticks[i+2] && longestPerimeter<sticks[i]+sticks[i+1]+sticks[i+2]) {
                triangle[0] = sticks[i];
                triangle[1] = sticks[i+1];
                triangle[2] = sticks[i+2];
                longestPerimeter = sticks[i]+sticks[i+1]+sticks[i+2];
            }
        }
        if (longestPerimeter != Integer.MIN_VALUE)
            return triangle;
        else
            return noTriangle;
    }
}
