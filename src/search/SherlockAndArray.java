package search;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SherlockAndArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int m = scanner.nextInt();
            List<Integer> arr = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                arr.add(scanner.nextInt());
            }
            System.out.println(balancedSums(arr));
        }
    }

    public static String balancedSums(List<Integer> arr) {
        int sumLeft = 0;
        int sumRight = 0;
        int iLeft = 0;
        int iRight = arr.size()-1;
        while (iRight-iLeft > 0) {
            if (sumLeft == sumRight) {
                if (sumLeft+arr.get(iLeft) > sumRight+arr.get(iRight))
                    sumRight += arr.get(iRight--);
                else
                    sumLeft += arr.get(iLeft++);
                continue;
            }
            if (sumLeft < sumRight)
                sumLeft += arr.get(iLeft++);
            else
                sumRight += arr.get(iRight--);
        }
        return sumLeft == sumRight ? "YES" : "NO";
    }
}
