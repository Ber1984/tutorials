package com.erick.company.datastructure.linkedlist.exercise;

public class RemoveThNode {

    static ListNode head;
    public static void main(String[] args) {
        System.out.println(insert(1));
        System.out.println(insert(2));
        System.out.println(insert(3));
        System.out.println(insert(4));
        System.out.println(insert(5));


        removeNthFromEnd(head, 2);
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
        if(head == null) {
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

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // Dummy node to handle edge cases like removing the head
        ListNode dummy = new ListNode(0); //We use a dummy node to simplify edge case handling.
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;

        // Move first pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        //first is moved n+1 steps ahead so that when it hits the end, second is just before the node to delete.
        // Move both until first reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return dummy.next;
    }
}
