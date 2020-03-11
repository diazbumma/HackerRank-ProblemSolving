package implementation;

import java.util.Scanner;

public class StrangeCounter {

    static long strangeCounter(long t) {
        long range = 3;
        long start = 0;

        while (start + range < t) {
            start += range;
            range *= 2;
        }

        return (range+1)-(t-start);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        long t = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = strangeCounter(t);

        System.out.println(result);

        scanner.close();
    }
}
