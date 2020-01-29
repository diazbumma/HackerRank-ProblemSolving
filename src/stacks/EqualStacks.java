package stacks;

import java.util.Scanner;
import java.util.Stack;

public class EqualStacks {

    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        int pipes1 = h1.length;
        int pipes2 = h2.length;
        int pipes3 = h3.length;

        Stack<Integer>[] stacks = new Stack[3];
        stacks[0] = new Stack<>();
        stacks[1] = new Stack<>();
        stacks[2] = new Stack<>();
        int[] height = new int[3];

        for (int i = pipes1-1; i >= 0; i--) {
            height[0] += h1[i];
            stacks[0].push(height[0]);
        }
        for (int i = pipes2-1; i >= 0; i--) {
            height[1] += h2[i];
            stacks[1].push(height[1]);
        }
        for (int i = pipes3-1; i >= 0; i--) {
            height[2] += h3[i];
            stacks[2].push(height[2]);
        }
        int smallestStack = 0;
        for (int i = 1; i < stacks.length; i++) {
            if (stacks[i].size() < stacks[smallestStack].size())
                smallestStack = i;
        }

        int otherStacks1 = 0;
        int otherStacks2 = 0;
        switch (smallestStack) {
            case 0:
                otherStacks1 = 1;
                otherStacks2 = 2;
                break;
            case 1:
                otherStacks1 = 0;
                otherStacks2 = 2;
                break;
            case 2:
                otherStacks1 = 0;
                otherStacks2 = 1;
                break;
        }

        int sameHeight = 0;
        for (int i = stacks[smallestStack].size()-1; i >= 0; i--) {
            int temp = stacks[smallestStack].get(i);
            if (stacks[otherStacks1].contains(temp) && stacks[otherStacks2].contains(temp)) {
                sameHeight = temp;
                break;
            }
        }
        return sameHeight;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] n1N2N3 = scanner.nextLine().split(" ");

        int n1 = Integer.parseInt(n1N2N3[0].trim());
        int n2 = Integer.parseInt(n1N2N3[1].trim());
        int n3 = Integer.parseInt(n1N2N3[2].trim());

        int[] h1 = new int[n1];

        String[] h1Items = scanner.nextLine().split(" ");

        for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
            int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
            h1[h1Itr] = h1Item;
        }

        int[] h2 = new int[n2];

        String[] h2Items = scanner.nextLine().split(" ");

        for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
            int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
            h2[h2Itr] = h2Item;
        }

        int[] h3 = new int[n3];

        String[] h3Items = scanner.nextLine().split(" ");

        for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
            int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
            h3[h3Itr] = h3Item;
        }

        int result = equalStacks(h1, h2, h3);

        System.out.println(result);
    }
}
