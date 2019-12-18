package queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * Solution: using queue only, no stacks
 */
public class QueueUsingTwoStacks {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < q; i++) {
            int type = scanner.nextInt();
            if (type == 1) {
                int data = scanner.nextInt();
                queue.add(data);
            } else if (type == 2) {
                queue.remove();
            } else {
                int out = queue.peek();
                System.out.println(out);
            }
        }

        scanner.close();
    }
}
