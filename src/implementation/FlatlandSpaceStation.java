package implementation;

import java.util.Arrays;
import java.util.Scanner;

public class FlatlandSpaceStation {

    static int flatlandSpaceStations(int n, int[] c) {
        int spaceStation = c.length;
        int maxDistance = Integer.MIN_VALUE;

        if (n == spaceStation)
            return 0;

        Arrays.sort(c);

        int traverseCity = 0;

        int firstDistance = ((c[0]) - traverseCity);
        if (firstDistance > maxDistance)
            maxDistance = firstDistance;
        traverseCity = c[0];

        for (int i = 1; i < spaceStation; i++) {
            int travelDistance = (c[i] - traverseCity) / 2;
            traverseCity = c[i];
            if (travelDistance > maxDistance)
                maxDistance = travelDistance;
        }

        if (traverseCity != n-1) {
            int lastDistance = ((n-1) - traverseCity);
            if (lastDistance > maxDistance)
                maxDistance = lastDistance;
        }

        return maxDistance;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[] c = new int[m];

        String[] cItems = scanner.nextLine().split(" ");
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = flatlandSpaceStations(n, c);

        System.out.println(result);

        scanner.close();
    }
}
