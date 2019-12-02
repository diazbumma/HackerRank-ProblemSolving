package linkedlists;

import java.util.Scanner;

public class InsertingANodeIntoASortedDoublyLinkedList {

    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);
            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }
            this.tail = node;
        }
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
            if (node != null) {
                System.out.print(sep);
            }
        }
    }
    
    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode node = head;
        DoublyLinkedListNode insert = new DoublyLinkedListNode(data);
        while (node.next!=null && node.data<data) {
            node = node.next;
        }
        if (node == head) {
            insert.next = head;
            head.prev = insert;
            head = insert;
        } else if (node.next==null && data>node.data) {
            node.next = insert;
            insert.prev = node;
        } else {
            insert.next = node;
            insert.prev = node.prev;
            node.prev.next = insert;
            node.prev = insert;
        }
        return head;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            DoublyLinkedList llist = new DoublyLinkedList();

            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            int data = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            DoublyLinkedListNode llist1 = sortedInsert(llist.head, data);

            printDoublyLinkedList(llist1, " ");
            System.out.print("\n");
        }
        scanner.close();
    }
}
