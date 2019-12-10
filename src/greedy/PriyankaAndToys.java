package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class PriyankaAndToys {

    static int toys(int[] w) {
        Arrays.sort(w);
        int container = 1;
        int minimumWeight = w[0]+4;
        for (int i = 1; i < w.length; i++) {
            if (!(w[i] <= minimumWeight)) {
                minimumWeight = w[i]+4;
                container++;
            }
        }
        return container;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] w = new int[n];

        String[] wItems = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            int wItem = Integer.parseInt(wItems[i]);
            w[i] = wItem;
        }

        int result = toys(w);
        System.out.println(result);
        scanner.close();
    }
}
