package com.erick.company.datastructure.linkedlist.exercise;

public class RemoveMiddle {

    static ListNode head;
    public static void main(String[] args) {
        System.out.println(insert(1));
        System.out.println(insert(3));
        System.out.println(insert(4));
        System.out.println(insert(7));
        System.out.println(insert(1));
        System.out.println(insert(2));
        System.out.println(insert(6));

        deleteMiddle(head);
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
    public static ListNode deleteMiddle(ListNode head) {

        // Case: only one node
        if (head == null || head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null; // to keep track of node before slow

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Delete the middle node
        prev.next = slow.next; //7 = 1
        //we're ommiting the middle and replace with the next value of middle

        return head;
    }
}
