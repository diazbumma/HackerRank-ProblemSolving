package linkedlists;

import java.util.Scanner;

public class DeleteDuplicateValueNodesFromASortedLinkedList {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);
            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }
            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
            if (node != null) {
                System.out.print(sep);
            }
        }
    }

    static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
        SinglyLinkedListNode node = head;
        while (node != null) {
            if (node.next!=null && node.next.data==node.data) {
                node.next = node.next.next;
                continue;
            }
            node = node.next;
        }
        return head;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        for (int tItr = 0; tItr < t; tItr++) {
            SinglyLinkedList llist = new SinglyLinkedList();
            int llistCount = scanner.nextInt();
            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                llist.insertNode(llistItem);
            }
            SinglyLinkedListNode llist1 = removeDuplicates(llist.head);
            printSinglyLinkedList(llist1, " ");
            System.out.print("\n");
        }
        scanner.close();
    }
}
