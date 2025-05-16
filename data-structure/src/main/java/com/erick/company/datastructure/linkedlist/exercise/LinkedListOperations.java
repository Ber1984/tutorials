package com.erick.company.datastructure.linkedlist.exercise;

/*
The head is the first node of a linked list.
 */
public class LinkedListOperations {
    static Node head;

    public static class Node {
        int data;
        Node next; //point to the next node

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        //create the operations to insert at the beginning, insert at the end,delete, count, print
        //System.out.println(insertAtFront(1));
        //System.out.println(insertAtFront(2));
        //System.out.println(insertAtFront(2));
        //System.out.println(insertAtFront(4));

        //insert
        System.out.println(insert(2));
        System.out.println(insert(4));
        System.out.println(insert(8));
        System.out.println(insert(99));

        System.out.println(reverse(head));
        //deleteAtEnd();
        print();
    }

    private static Node insertAtFront(int val) {
        Node newNode = new Node(val); //new node
        newNode.next = head; //point the current head next of a new node

        //null
        //1 - null
        //head = 1 -> null
        head = newNode;
        return head;
    }

    //Usually means add to end
    private static Node insert(int val) {
        Node newNode = new Node(val);
        if(head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
        return head;
    }

    private static void deleteAtEnd() {
        Node curr = head;
        while (curr != null) {
            if(curr.next.next == null) { //second
                curr.next = null;
                break;
            }
            curr = curr.next;
        }
    }

    private static void print() {
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    private static int count() {
        int cnt = 0;
        while (head != null) {
            cnt++;
            head = head.next;
        }
        return cnt;
    }

    private static Node reverse(Node head) {
        //99 - 8 - 4 - 2
        // 2 - null 4 - 8 - 99
        Node prev = null; //perfect
        Node curr = head;//perfect

        while (curr != null) {
            Node next = curr.next; //perfect
            curr.next = prev; //null;
            prev = curr; //2
            curr = next;
        }
        head = prev;
        return head;
    }


}
