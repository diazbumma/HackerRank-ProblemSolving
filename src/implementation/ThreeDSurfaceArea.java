package implementation;

import java.util.Scanner;

public class ThreeDSurfaceArea {

    static int surfaceArea(int[][] A) {
        int length = A.length;
        int depth = A[0].length;
        int surface = 2 * (length*depth);

        for (int i = 0; i < length; i++) {
            int front = A[i][0];
            int side = 0;
            for (int j = 0; j < depth; j++) {
                if (j != depth-1) {
                    front += Math.abs(A[i][j] - A[i][j + 1]);
                } else {
                    front += A[i][j];
                }

                if (i == 0) {
                    side += A[i][j];
                    if (length != 1)
                        side += Math.abs(A[i][j] - A[i+1][j]);
                    else
                        side += A[i][j];
                } else if (i != length-1) {
                    side += Math.abs(A[i][j] - A[i+1][j]);
                } else {
                    side += A[i][j];
                }
            }
            surface += (front+side);
        }

        return surface;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] HW = scanner.nextLine().split(" ");

        int H = Integer.parseInt(HW[0]);

        int W = Integer.parseInt(HW[1]);

        int[][] A = new int[H][W];

        for (int i = 0; i < H; i++) {
            String[] ARowItems = scanner.nextLine().split(" ");
            //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < W; j++) {
                int AItem = Integer.parseInt(ARowItems[j]);
                A[i][j] = AItem;
            }
        }

        int result = surfaceArea(A);

        System.out.println(result);

        scanner.close();
    }
}
