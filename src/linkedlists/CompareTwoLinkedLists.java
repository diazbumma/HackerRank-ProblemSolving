package linkedlists;

import java.util.Scanner;

public class CompareTwoLinkedLists {

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

    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode node1 = head1;
        SinglyLinkedListNode node2 = head2;
        while (node1!=null || node2!=null) {
            if (node1.data != node2.data)
                return false;
            else if ((node1.next!=null && node2.next==null) || (node2.next!=null && node1.next==null))
                return false;
            node1 = node1.next;
            node2 = node2.next;
        }
        return true;
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
            boolean result = compareLists(llist1.head, llist2.head);
            System.out.println(result ? 1 : 0);
        }
        scanner.close();
    }
}
