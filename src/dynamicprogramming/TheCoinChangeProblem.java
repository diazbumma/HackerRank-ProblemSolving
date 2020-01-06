package dynamicprogramming;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class TheCoinChangeProblem {

    /*
     * memoization index based on constraint:
     * 1 <= n <= 250
     * 1 <= m <= 50
     */
    private static long[][] lookup = new long[251][51];

    public static long getWays (long n, List<Long> coins) {
        if (n == 0)
            return 1;

        int size = coins.size();

        if (lookup[(int) n][size] == 0) {
            long combi = 0;
            for (int i = 0; i < size; i++) {
                long sisa = n-coins.get(i);

                if (sisa < 0)
                    continue;

                combi += getWays(sisa, coins.subList(i, size));
            }
            lookup[(int) n][size] = combi;
        }

        return lookup[(int) n][size];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] firstMultipleInput = scanner.nextLine().replaceAll("\\s+$", "").split(" ");

        long n = Long.parseLong(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Long> c = Stream.of(scanner.nextLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'

        long ways = getWays(n, c);

        System.out.println(ways);

        scanner.close();
    }
}
