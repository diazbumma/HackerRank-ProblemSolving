package stacks;

import java.util.Scanner;
import java.util.Stack;

public class MaximumElement {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Stack<Integer> elements = new Stack<>();
        int N = scanner.nextInt();
        int max = 0;
        for (int i = 0; i < N; i++) {
            int type = scanner.nextInt();
            if (type == 1) {
                int x = scanner.nextInt();
                if (x > max)
                    max = x;
                elements.push(x);
            } else if (type == 2) {
                int peek = elements.peek();
                if (peek == max) {
                    elements.pop();
                    max = 0;
                    if (!elements.isEmpty()) {
                        for (Integer integer : elements) {
                            if (integer > max)
                                max = integer;
                        }
                    }
                } else {
                    elements.pop();
                }
            } else {
                System.out.println(max);
            }
        }
    }
}
