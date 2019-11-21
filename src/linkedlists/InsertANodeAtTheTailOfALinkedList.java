package linkedlists;

import java.util.Scanner;

public class InsertANodeAtTheTailOfALinkedList {

    public static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    public static class SinglyLinkedList {
        public SinglyLinkedListNode head;

        public SinglyLinkedList() {
            this.head = null;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
            if (node != null)
                System.out.print(sep);
        }
    }

    public static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        if (head != null) {
            SinglyLinkedListNode temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = new SinglyLinkedListNode(data);
        } else {
            head = new SinglyLinkedListNode(data);
        }
        return head;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SinglyLinkedList llist = new SinglyLinkedList();
        int llistCount = scanner.nextInt();
        for (int i = 0; i < llistCount; i++) {
            int llistItem = scanner.nextInt();
            llist.head = insertNodeAtTail(llist.head, llistItem);
        }
        printSinglyLinkedList(llist.head, "\n");
        scanner.close();
    }
}
