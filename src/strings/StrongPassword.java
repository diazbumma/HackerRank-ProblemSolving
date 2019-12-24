package strings;

import java.util.Scanner;

public class StrongPassword {

    /*
    numbers = "0123456789"
    lower_case = "abcdefghijklmnopqrstuvwxyz"
    upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    special_characters = "!@#$%^&*()-+"
    */
    static int minimumNumber(int n, String password) {
        int additionalChar = 0;

        int numbers = 0;
        int lowerCase = 0;
        int upperCase = 0;
        int specialChar = 0;
        int additionalLength = 0;

        if (password.length() < 6)
            additionalLength = 6-password.length();

        for (int i = 0; i < password.length(); i++) {
            char letter = password.charAt(i);
            if (letter>='A' && letter<='Z')
                upperCase++;
            else if (letter>='a' && letter<='z')
                lowerCase++;
            else if (letter>='0' && letter<='9')
                numbers++;
            else
                specialChar++;
        }

        if (numbers == 0)
            additionalChar++;
        if (lowerCase == 0)
            additionalChar++;
        if (upperCase == 0)
            additionalChar++;
        if (specialChar == 0)
            additionalChar++;

        return Math.max(additionalChar, additionalLength);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();

        int answer = minimumNumber(n, password);

        System.out.println(answer);

        scanner.close();
    }
}
