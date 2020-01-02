package implementation;

import java.util.Scanner;

public class HalloweenSale {

    static int howManyGames(int p, int d, int m, int s) {
        if (p > s)
            return 0;

        int games = 0;
        int price = p;
        int costs = 0;
        int moneyLeft = s;

        while (price >= m && costs <= s) {
            costs += price;
            moneyLeft -= price;

            ++games;

            price -= d;
        }

        games += (moneyLeft/m);

        return games;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] pdms = scanner.nextLine().split(" ");

        int p = Integer.parseInt(pdms[0]);

        int d = Integer.parseInt(pdms[1]);

        int m = Integer.parseInt(pdms[2]);

        int s = Integer.parseInt(pdms[3]);

        int answer = howManyGames(p, d, m, s);

        System.out.println(answer);

        scanner.close();
    }
}
