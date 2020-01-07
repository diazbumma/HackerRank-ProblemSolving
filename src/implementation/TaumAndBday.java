package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class TaumAndBday {

    public static long taumBday(long b, long w, long bc, long wc, long z) {
        long minimumCost;
        long totalCost;
        long additional;
        long totalGift = b+w;
        long blackOnly = b*bc;
        long whiteOnly = w*wc;

        if (bc > wc+z) {
            additional = b*z;
            totalCost = totalGift*wc;
            minimumCost = totalCost + additional;
        } else if (wc > bc+z) {
            additional = w*z;
            totalCost = totalGift*bc;
            minimumCost = totalCost + additional;
        } else {
            minimumCost = blackOnly + whiteOnly;
        }

        return minimumCost;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int b = Integer.parseInt(firstMultipleInput[0]);

                int w = Integer.parseInt(firstMultipleInput[1]);

                String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int bc = Integer.parseInt(secondMultipleInput[0]);

                int wc = Integer.parseInt(secondMultipleInput[1]);

                int z = Integer.parseInt(secondMultipleInput[2]);

                long result = taumBday(b, w, bc, wc, z);

                System.out.println(result);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
