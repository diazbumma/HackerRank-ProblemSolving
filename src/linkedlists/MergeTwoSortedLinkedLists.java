package linkedlists;

import java.util.Scanner;

public class MergeTwoSortedLinkedLists {

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

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode node1 = head1;
        SinglyLinkedListNode node2 = head2;
        SinglyLinkedListNode mergeNode = null;
        SinglyLinkedListNode mergeHead = null;
        while (node1!=null && node2!=null) {
            SinglyLinkedListNode newNode;
            if (node1.data < node2.data) {
                newNode = new SinglyLinkedListNode(node1.data);
                node1 = node1.next;
            } else {
                newNode = new SinglyLinkedListNode(node2.data);
                node2 = node2.next;
            }
            if (mergeNode == null) {
                mergeNode = newNode;
                mergeHead = mergeNode;
            } else {
                mergeNode.next = newNode;
                mergeNode = mergeNode.next;
            }
        }
        if (node1 != null) {
            while (node1 != null) {
                mergeNode.next = new SinglyLinkedListNode(node1.data);
                mergeNode = mergeNode.next;
                node1 = node1.next;
            }
        } else {
            while (node2 != null) {
                mergeNode.next = new SinglyLinkedListNode(node2.data);
                mergeNode = mergeNode.next;
                node2 = node2.next;
            }
        }
        return mergeHead;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int tests = scanner.nextInt();
        for (int testsItr = 0; testsItr < tests; testsItr++) {
            SinglyLinkedList llist1 = new SinglyLinkedList();
            int llist1Count = scanner.nextInt();
            for (int i = 0; i < llist1Count; i++) {
                int llist1Item = scanner.nextInt();
                llist1.insertNode(llist1Item);
            }
            SinglyLinkedList llist2 = new SinglyLinkedList();
            int llist2Count = scanner.nextInt();
            for (int i = 0; i < llist2Count; i++) {
                int llist2Item = scanner.nextInt();
                llist2.insertNode(llist2Item);
            }
            SinglyLinkedListNode llist3 = mergeLists(llist1.head, llist2.head);
            printSinglyLinkedList(llist3, " ");
            System.out.print("\n");
        }
        scanner.close();
    }
}
