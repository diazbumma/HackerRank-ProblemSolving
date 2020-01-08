package implementation;

import java.util.Scanner;

public class CavityMap {

    static String[] cavityMap(String[] grid) {
        int length = grid[0].length();
        int width = grid.length;

        String[] map = new String[width];
        for (int i = 0; i < width; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < length; j++) {
                if (i != 0 && i != width-1 && j != 0 && j != length-1 &&
                        (grid[i].charAt(j) > grid[i].charAt(j-1) && grid[i].charAt(j) > grid[i].charAt(j+1)) &&
                        (grid[i].charAt(j) > grid[i-1].charAt(j) && grid[i].charAt(j) > grid[i+1].charAt(j))) {
                    stringBuilder.append("X");
                } else {
                    stringBuilder.append(grid[i].charAt(j));
                }
            }
            map[i] = stringBuilder.toString();
        }

        return map;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] result = cavityMap(grid);

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
