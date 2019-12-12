package implementation;

import java.util.Scanner;

public class RepeatedString {

    static long repeatedString(String s, long n) {
        long originalLength = s.length();
        long aCountS = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a')
                aCountS++;
        }

        long aCountRepeated = (n/originalLength)*aCountS;
        long repeatedSLength = (n/originalLength)*originalLength;

        if (repeatedSLength < n) {
            for (int i = 0; i < s.length(); i++) {
                repeatedSLength++;
                if (s.charAt(i) == 'a')
                    aCountRepeated++;
                if (repeatedSLength == n)
                    break;
            }
        }

        return aCountRepeated;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        System.out.println(result);

        scanner.close();
    }
}
