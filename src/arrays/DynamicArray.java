package arrays;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        int lastAnswer = 0;
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer>[] seq = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            seq[i] = new ArrayList<>();
        }
        for (int i = 0; i < queries.size(); i++) {
            int type = queries.get(i).get(0);
            int x = queries.get(i).get(1);
            int y = queries.get(i).get(2);
            if (type == 1) {
                int index = ((x^lastAnswer) % n);
                seq[index].add(y);
            } else {
                int index = ((x^lastAnswer) % n);
                lastAnswer = seq[index].get(y % seq[index].size());
                result.add(lastAnswer);
            }
        }
        return result;
    }
}

public class DynamicArray {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.dynamicArray(n, queries);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
