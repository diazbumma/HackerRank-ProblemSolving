package strings;

import java.util.Scanner;

public class PalindromeIndex {

    static int palindromeIndex(String s) {
        int length = s.length();
        int end = length-1;
        int start = 0;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                if (end-start != 1) {
                    if (s.charAt(start + 1) == s.charAt(end) && s.charAt(start + 2) == s.charAt(end - 1))
                        return start;
                    else
                        return end;
                }
                else {
                    if (s.charAt(start -1) == s.charAt(end))
                        return start;
                    else
                        return end;
                }
            }

            ++start;
            --end;
        }

        return -1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = palindromeIndex(s);

            System.out.println(result);
        }

        scanner.close();
    }
}
