package LeetCode;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class AddTwoNumbers {
    public static void main(String[] args) {
        addTwoNumbers();
    }

    public static LinkedList<Integer> addTwoNumbers() {
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(2);
        list1.add(4);
        list1.add(3);
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(5);
        list2.add(6);
        list2.add(4);
        
        return null;
    }

    class ListNode {

        private int data; // Represent the element of the linklist
        private ListNode next; // A pointer/reference to the next element

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }

    ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextElement = current.getNext();
            current.setNext(previous);
            previous = current;
            current = nextElement;
        }
        return previous;
    }
}
