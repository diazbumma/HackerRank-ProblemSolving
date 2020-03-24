package implementation;

import java.util.Scanner;

public class AppendAndDelete {

    // This is a stupid solution, but it's working
    // Working for more reasonable solution on case with length of string s < t later
    static String appendAndDelete(String s, String t, int k) {
        int sLength = s.length();
        int tLength = t.length();

        if (sLength < tLength) {
            if (tLength + sLength > k) {
                int i = sLength-1;
                if (tLength - i == k-1)
                    return "Yes";
                return "No";
            }
        }

        int i = 0;
        while (i < tLength && i < sLength) {
            if (s.charAt(i) == t.charAt(i))
                ++i;
            else
                break;
        }

        if ((sLength-i) + (tLength-i) > k)
            return "No";

        return "Yes";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String s = scanner.nextLine();

        String t = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = appendAndDelete(s, t, k);

        System.out.println(result);

        scanner.close();
    }
}
