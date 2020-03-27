package implementation;

import java.util.ArrayList;
import java.util.Scanner;

public class ACMICPCTeam {

    static int calcTopic(String att1, String att2) {
        int total = 0;

        for (int i = 0; i < att1.length(); i++) {
            if (att1.charAt(i) == '1' || att2.charAt(i) == '1')
                ++total;
        }

        return total;
    }

    static int[] acmTeam(String[] topic) {
        ArrayList<Integer> countTopics = new ArrayList<>();

        for (int i = 0; i < topic.length - 1; i++) {
            for (int j = i+1; j < topic.length; j++) {
                countTopics.add(calcTopic(topic[i], topic[j]));
            }
        }

        int[] result = new int[2];
        result[0] = Integer.MIN_VALUE;

        for (int temp : countTopics) {
            if (temp > result[0]) {
                result[0] = temp;
                result[1] = 1;
            } else if (temp == result[0]) {
                ++result[1];
            }
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        String[] topic = new String[n];

        for (int i = 0; i < n; i++) {
            String topicItem = scanner.nextLine();
            topic[i] = topicItem;
        }

        int[] result = acmTeam(topic);

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
