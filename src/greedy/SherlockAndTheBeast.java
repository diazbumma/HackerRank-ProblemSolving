package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class SherlockAndTheBeast {

    static void decentNumber(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        int five = n / 3;
        int remainder = n % 3;

        while (remainder % 5 != 0 && five > 0) {
            --five;
            remainder += 3;
        }

        for (int i = 0; i < five; i++) {
            stringBuilder.append("555");
        }

        for (int i = 0; i < (remainder/5); i++) {
            stringBuilder.append("33333");
        }

        if (five == 0 && remainder % 5 != 0)
            System.out.println("-1");
        else
            System.out.println(stringBuilder.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                decentNumber(n);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
