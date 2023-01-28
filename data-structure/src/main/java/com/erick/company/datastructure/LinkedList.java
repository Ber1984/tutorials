package com.erick.company.datastructure;

public class LinkedList {
    Node head;
    int total;

    public static class Node {
        int data;
        Node next;

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

    public void append(Node node, int data) {
        if (this.head == null || node == null) return;
        Node newNode = new Node(data);
        Node prev = node;
        Node next = node.next;

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
