package bitmanipulation;

import java.util.Scanner;

public class FlippingBits {

    static long flippingBits(long n) {
        String conv = Long.toBinaryString(n);
        char[] flipped = new char[32];
        int iFLip = 31;
        int iConv = conv.length()-1;
        while (iFLip >= 0) {
            if (iConv < 0) {
                flipped[iFLip] = '1';
                iFLip--;
                continue;
            }
            if (conv.charAt(iConv) == '0')
                flipped[iFLip] = '1';
            else
                flipped[iFLip] = '0';
            iConv--;
            iFLip--;
        }
        return Long.parseUnsignedLong(String.valueOf(flipped), 2);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            long n = scanner.nextLong();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            long result = flippingBits(n);

            System.out.println(result);
        }

        scanner.close();
    }
}
