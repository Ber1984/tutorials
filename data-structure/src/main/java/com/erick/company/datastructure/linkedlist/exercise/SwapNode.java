package com.erick.company.datastructure.linkedlist.exercise;

public class SwapNode {

    static ListNode head;
    public static void main(String[] args) {
        System.out.println(insert(1));
        System.out.println(insert(2));
        System.out.println(insert(3));
        System.out.println(insert(4));
        System.out.println(insert(5));


        System.out.println(swapNodes(head, 2));
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

    /*
    In this case, we didn't need a dummy node because:
     We're Only Swapping Values — Not Removing or Re-linking Nodes
A dummy node is helpful when you might modify the actual head (like deleting the first node).

But here, you're not changing any node links (.next references); you're just swapping the .val values of two existing nodes.

So there's no risk of losing the head or needing to reassign it.
     */
    public static ListNode swapNodes(ListNode head, int k) {
        ListNode first = head;
        ListNode second = head;

        // Step 1: Find kth node from the beginning
        for (int i = 1; i < k; i++) {
            first = first.next;
        }
        ListNode kthFromStart = first;

        // Step 2: Use another pointer to find kth node from the end
        ListNode fast = first;
        while (fast.next != null) {
            fast = fast.next;
            second = second.next;
        }
        ListNode kthFromEnd = second;

        // Step 3: Swap the values
        int temp = kthFromStart.val;
        kthFromStart.val = kthFromEnd.val;
        kthFromEnd.val = temp;

        return head;

    }
}
