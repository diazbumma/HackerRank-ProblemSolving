package trees;

import java.util.Scanner;

public class TreeHeightOfABinaryTree {

    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static int height(Node root) {
        if (root.left==null && root.right==null) {
            return 0;
        } else {
            int childHeightLeft = 0;
            int childHeightRight = 0;
            if (root.left != null)
                childHeightLeft = height(root.left);
            if (root.right != null)
                childHeightRight = height(root.right);
            if (childHeightLeft > childHeightRight)
                return childHeightLeft + 1;
            else
                return childHeightRight + 1;
        }
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }
}
