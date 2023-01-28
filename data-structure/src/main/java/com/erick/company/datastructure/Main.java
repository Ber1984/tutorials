package com.erick.company.datastructure;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        /*
        LinkedList.Node nodeA = new LinkedList.Node(6);
        LinkedList.Node nodeB = new LinkedList.Node(3);
        LinkedList.Node nodeC = new LinkedList.Node(4);
        LinkedList.Node nodeD = new LinkedList.Node(2);
        LinkedList.Node nodeE = new LinkedList.Node(1);


        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;
        nodeD.next = nodeE;

         */
        LinkedList list1 = new LinkedList();
        list1.add(5);
        list1.add(10);
        list1.add(15);
        list1.add(20);
        list1.add(25);

        list1.append(list.getNodeAt(1), 30);
        list1.delete(list.getNodeAt(4));

        list1.print();

    }
}
