package com.erick.company.datastructure.linkedlist.exercise;

public class SwapPairs {

    static ListNode head;

    public static void main(String[] args) {
        System.out.println(insert(1));
        System.out.println(insert(2));
        System.out.println(insert(3));
        System.out.println(insert(4));
        System.out.println(insert(5));


        System.out.println(swapPairs(head));
    }

    public static class ListNode {
        int val;
        ListNode next; //point to the next node

        public ListNode(int data) {
            this.val = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    private static ListNode insert(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
        } else {
            ListNode curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
        return head;
    }

    public static ListNode swapPairs(ListNode head) {

        // Dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;

            // Swapping
            first.next = second.next;
            second.next = first;
            current.next = second;

            // Move to the next pair
            current = first;
        }

        return dummy.next;

    }
}
