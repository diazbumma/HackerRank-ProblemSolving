package stacks;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

    static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);

            if (temp == '(' || temp == '{' || temp == '[') {
                stack.push(temp);
            } else {
                if (
                        !stack.isEmpty() &&
                                ((temp == ')' && stack.peek() == '(') ||
                                        (temp == '}' && stack.peek() == '{') ||
                                        (temp == ']' && stack.peek() == '['))
                ) {
                    stack.pop();
                } else {
                    stack.push(temp);
                }
            }
        }

        if (stack.isEmpty())
            return "YES";
        else
            return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            System.out.println(result);
        }

        scanner.close();
    }
}
