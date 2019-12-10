package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class JimAndTheOrders {

    static class Table implements Comparable {
        int number;
        int serveTime;

        Table(int number, int serveTime) {
            this.number = number;
            this.serveTime = serveTime;
        }

        @Override
        public int compareTo(Object o) {
            Table table = (Table) o;
            return Integer.compare(this.serveTime, table.serveTime);
        }
    }

    static int[] jimOrders(int[][] orders) {
        Table[] serveTime = new Table[orders.length];
        for (int i = 0; i < serveTime.length; i++) {
            serveTime[i] = new Table(i+1, orders[i][0] + orders[i][1]);
        }
        Arrays.sort(serveTime);
        int[] table = new int[serveTime.length];
        for (int i = 0; i < table.length; i++) {
            table[i] = serveTime[i].number;
        }
        return table;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] orders = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] ordersRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int ordersItem = Integer.parseInt(ordersRowItems[j]);
                orders[i][j] = ordersItem;
            }
        }

        int[] result = jimOrders(orders);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i != result.length - 1) {
                System.out.print(" ");
            }
        }

        System.out.print("\n");
        scanner.close();
    }
}
