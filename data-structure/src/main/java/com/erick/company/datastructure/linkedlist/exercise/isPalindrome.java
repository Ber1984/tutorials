package com.erick.company.datastructure.linkedlist.exercise;

import java.util.ArrayList;

public class isPalindrome {
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
    public static void main(String[] args) {

    }

    /*
    Reverse a copy of the list.
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        //1 1 2 1
        //1 2 1 1
        // Step 1: Clone the list
        ListNode clone = null;
        ListNode temp = head;
        ListNode cloneTail = null;

        while (temp != null) {
            ListNode node = new ListNode(temp.val);
            if (clone == null) {
                clone = node;
                cloneTail = node;
            } else {
                cloneTail.next = node;
                cloneTail = node;
            }
            temp = temp.next;
        }

        ListNode prev = null;
        ListNode curr = clone;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode reverseListNode = prev;

        while (head != null) {
            if (reverseListNode.val != head.val) {
                return false;
            }
            reverseListNode = reverseListNode.next;
            head = head.next;
        }

        return true;

    }

    /*
    Or (better): Use the fast and slow pointer technique to reverse just the second half in-place, and then compare both halves.
     Fast and Slow Pointer Technique
This is a general technique used for various problems in linked lists:

Fast pointer moves 2 steps at a time.

Slow pointer moves 1 step at a time.

You use it for:

Finding the middle of a list.

Detecting palindromes.

Reversing the second half.

Splitting a list.

     */


    private void findMiddleList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Now 'slow' is at the middle

    }

    /*
    This uses fast and slow pointers, but specifically to detect cycles in a linked list.

        How it works:

        If there's a cycle, fast and slow pointers will eventually meet.

        If no cycle, fast will reach null.
     */
    private boolean tortoiseAndHare(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;

    }

    //The slow pointer will point to the start of the second half, so you typically do:
    public boolean isPalindromeFastSlowTechnique(ListNode head) {
        if (head == null || head.next == null) return true;

        // 1. Find the middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse the second half
        ListNode prev = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        // 3. Compare first half and reversed second half
        ListNode left = head; //full list
        ListNode right = prev; //prev has my reverse list

        while (right != null) {  // Only compare half
            if (left.val != right.val) return false;
            left = left.next;
            right = right.next;
        }

        return true;

    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }
}
