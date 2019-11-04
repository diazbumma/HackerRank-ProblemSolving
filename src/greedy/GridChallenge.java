package greedy;

import java.util.Arrays;
import java.util.Scanner;

/*
 * but somehow, i don't see any greedy patterns in here
 */
public class GridChallenge {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        for (int i=0; i<t; i++) {
            int n = scanner.nextInt();
            scanner.nextLine();
            String[] grid = new String[n];
            for (int j=0; j<n; j++) {
                String gridItem = scanner.nextLine();
                grid[j] = gridItem;
            }
            System.out.println(gridChallenge(grid));
        }
    }

    public static String gridChallenge(String[] grid) {
        int y = grid.length;
        int x = grid[0].length();
        char[][] gridCopy = new char[y][x];
        for (int i=0; i<y; i++) {
            char[] charArray = grid[i].toCharArray();
            Arrays.sort(charArray);
            for (int j=0; j<charArray.length; j++)
                gridCopy[i][j] = charArray[j];
        }
        for (int i = 0; i < x; i++) {
            for (int j = 1; j < y; j++)
                if (gridCopy[j-1][i] > gridCopy[j][i])
                    return "NO";
        }
        String[] row = new String[y];
        String[] col = new String[x];
        for (int i=0; i<y; i++) {
            row[i] = "";
            for (int j=0; j<x; j++)
                row[i] += gridCopy[i][j];
        }
        for (int i=0; i<x; i++) {
            col[i] = "";
            for (int j=0; j<y; j++)
                col[i] += gridCopy[j][i];
        }
        for (int i = 1; i < y; i++)
            if (row[i].compareTo(row[i-1])<0)
                return "NO";
        for (int i = 1; i < x; i++)
            if (col[i].compareTo(col[i-1])<0)
                return "NO";
        return "YES";
    }
}
