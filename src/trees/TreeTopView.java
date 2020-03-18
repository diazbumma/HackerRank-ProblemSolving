package trees;

import java.util.*;

public class TreeTopView {

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

    public static void topView(Node root) {
        Queue<Node> queue = new LinkedList<>();
        Queue<Integer> queueLevel = new LinkedList<>();
        TreeMap<Integer, Node> map = new TreeMap<>();

        queue.add(root);
        queueLevel.add(0);

        while (!queue.isEmpty()) {
            int currSize = queue.size();

            for (int i = 0; i < currSize; i++) {
                Node traverse = queue.poll();
                int level = queueLevel.poll();

                if (!map.containsKey(level)) {
                    map.put(level, traverse);
                }

                if (traverse.left != null) {
                    queue.add(traverse.left);
                    queueLevel.add(level-1);
                }
                if (traverse.right != null) {
                    queue.add(traverse.right);
                    queueLevel.add(level+1);
                }
            }
        }

        for (Map.Entry<Integer, Node> item : map.entrySet()) {
            System.out.print(item.getValue().data + " ");
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
        topView(root);
    }
}
