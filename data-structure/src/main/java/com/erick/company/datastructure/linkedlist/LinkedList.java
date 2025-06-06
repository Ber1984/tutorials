package com.erick.company.datastructure.linkedlist;
/*
 What is a LinkedList?
A LinkedList is a linear data structure where elements (called nodes) are stored in non-contiguous memory locations and are linked using pointers. Each node contains:

Data

Reference to the next node (and optionally, the previous node in doubly linked lists)

Java provides LinkedList as a part of the java.util package, which implements both:

List interface → ordered collection (like ArrayList)

Deque interface → double-ended queue (can add/remove from both ends)

🧱 Types of Linked Lists
Singly Linked List

Each node points to the next.

Unidirectional.

Simple and uses less memory.

Doubly Linked List

Each node points to both the next and previous nodes.

Bidirectional.

Slightly more memory due to extra pointer.

Circular Linked List

Last node points back to the first.

Can be singly or doubly circular.

The head is the first node of a linked list.
 */
public class LinkedList {
    Node head; //head is the node itself
    int total;

    public static class Node {
        int data;
        Node next; //point to the next node

        public Node(int data) {
            this.data = data;
        }


    }


    public Node getNodeAt(int pos) {
        if (this.head != null || (this.total - 1) < pos) return null;
        Node control = this.head;
        int x = 0;
        while (control != null) {
            if (x == pos) break;
            x++;
            control = control.next;
        }
        return control;
    }

    public void append(Node head, int data) {
        if (this.head == null || head == null) return;
        Node newNode = new Node(data); //create a new head
        Node prev = head; //current head point to prev
        Node next = head.next;

        prev.next = newNode;
        newNode.next = next;
        this.total++;
    }

    void delete(Node node) {
        if (this.head == null || node == null) return;
        Node control = this.head;
        Node temp = null;
        if (node == head) {
            temp = this.head;
            this.head = this.head.next;
            temp = null;
        } else {
            while (control.next != node) {
                control = control.next;
            }
            temp = control.next;
            control.next = temp.next;
            temp = null;
        }
        this.total--;
    }

    void add(int data) {
        Node newNode = new Node(data);
        newNode.next = null;
        if (this.head == null) {
            head = newNode;
        } else {
            Node last = getLastNode();
            last.next = newNode;
        }
        this.total++;
    }

    private Node getLastNode() {
        if (this.head == null) return null;
        Node last = this.head;
        Node control = this.head;
        while (control != null) {
            last = control;
            control = last.next;
        }
        return last;
    }

    public void print() {
        Node node = this.head;
        while (node != null) {
            System.out.println("*" + node.data);
            node = node.next;
        }
    }

    int codeNotes(Node head) {
        int count = 1;
        Node current = head;
        while (current.next != null) {
            current = current.next;
            count += 1;
        }
        return count;
    }
}
