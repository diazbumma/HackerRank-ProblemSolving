package implementation;

import java.util.Scanner;

public class Encryption {

    //sample test case
    //if man was meant to stay on the ground god would have given us roots
    //imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(encryption(input));
        scanner.close();
    }

    public static String encryption(String s) {
        s = s.replaceAll(" ", "");
        int l = s.length();
        int row = (int) Math.floor(Math.sqrt(l));
        int col = (int) Math.ceil(Math.sqrt(l));
        if (row*col<l)
            row = col;
        char[][] table = new char[15][15];
        int temp = 0;
        boolean enough = false;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                table[i][j] = s.charAt(temp);
                temp++;
                if (temp==l) {
                    enough = true;
                    break;
                }
            }
            if (enough)
                break;
        }
        temp = 0;
        enough = false;
        StringBuilder encoded = new StringBuilder();
        for (int i=0; i<col; i++) {
            for (int j=0; j<row; j++) {
                if (table[j][i]==0)
                    continue;
                encoded.append(table[j][i]);
                temp++;
                if (temp==l) {
                    enough = true;
                    break;
                }
            }
            if (enough)
                break;
            encoded.append(" ");
        }
        return encoded.toString();
    }
}
