package strings;

import java.util.HashSet;
import java.util.Scanner;

public class WeightedUniformStrings {

    static String[] weightedUniformStrings(String s, int[] queries) {
        HashSet<Integer> set = new HashSet<>();
        String[] result = new String[queries.length];

        char frontier = 'A';
        int frontierWeight = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != frontier) {
                frontier = s.charAt(i);
                frontierWeight = (frontier - 96);
            } else {
                frontierWeight += (frontier - 96);
            }

            set.add(frontierWeight);
        }

        for (int i = 0; i < queries.length; i++) {
            if (set.contains(queries[i]))
                result[i] = "Yes";
            else
                result[i] = "No";
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String s = scanner.nextLine();

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] queries = new int[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }

        String[] result = weightedUniformStrings(s, queries);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

        scanner.close();
    }
}
