package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

public class TheFullCountingSort {

    static void countSort(List<List<String>> arr, int size) {
        int halfSize = size/2;
        StringBuilder[] words = new StringBuilder[100];

        for (int i = 0; i < words.length; i++) {
            words[i] = new StringBuilder();
        }

        for (int i = 0; i < halfSize; i++) {
            int arrIndex = Integer.parseInt(arr.get(i).get(0));

            words[arrIndex].append("- ");
        }

        for (int i = halfSize; i < size; i++) {
            int arrIndex = Integer.parseInt(arr.get(i).get(0));

            words[arrIndex].append(arr.get(i).get(1));
            words[arrIndex].append(" ");
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (StringBuilder word : words) {
            if (word != null)
                stringBuilder.append(word);
        }

        System.out.println(stringBuilder.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        countSort(arr, n);

        bufferedReader.close();
    }
}
