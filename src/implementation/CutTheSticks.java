package implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CutTheSticks {

    static int[] cutTheSticks(int[] arr) {
        Arrays.sort(arr);
        List<Integer> cut= new ArrayList<>();

        int minStick = arr[0];
        int stickCuts = arr.length;
        cut.add(stickCuts);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > minStick) {
                minStick = arr[i];
                cut.add(stickCuts);
            }
            stickCuts--;
        }

        int[] toArray = new int[cut.size()];
        for (int i = 0; i < toArray.length; i++) {
            toArray[i] = cut.get(i);
        }
        return toArray;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = cutTheSticks(arr);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);

            if (i != result.length - 1) {
                System.out.print("\n");
            }
        }

        System.out.print("\n");
        scanner.close();
    }
}
