package com.erick.company.collections;

import java.util.*;

public class TreeSetTest {
    public static void main(String[] args) {
        /*
        TreeSet is one of the most important implementations of the SortedSet interface in Java that uses a Tree for storage.
        */
        Set<String> emptySet = new TreeSet<>();
        emptySet.add(null);

        Set<String> ts10 = new TreeSet<>();

        // Elements are added using add() method
        ts10.add("A");
        ts10.add("B");
        ts10.add("C");
        ts10.add(null);
        // Duplicates will not get insert
        ts10.add("C");

        // Elements get stored in default natural
        // Sorting Order(Ascending)
        System.out.println(ts10);

        Set<StringBuffer> stringBufferSet = new TreeSet<>();
        stringBufferSet.add(new StringBuffer("Hola"));



        SortedSet<String> ts1 = new TreeSet<>();
        AbstractSet<String> ts4 = new TreeSet<>();
        NavigableSet<Integer> ns = new TreeSet<>();
        ns.add(0);
        ns.add(1);
        ns.add(2);
        ns.add(3);
        ns.add(4);
        ns.add(5);
        ns.add(6);

        // Get a reverse view of the navigable set
        NavigableSet<Integer> reverseNs = ns.descendingSet();

        // Print the normal and reverse views
        System.out.println("Normal order: " + ns);
        System.out.println("Reverse order: " + reverseNs);

        NavigableSet<Integer> threeOrMore = ns.tailSet(3, true);
        System.out.println("3 or  more:  " + threeOrMore);
        System.out.println("lower(3): " + ns.lower(3));
        System.out.println("floor(3): " + ns.floor(3));
        System.out.println("higher(3): " + ns.higher(3));
        System.out.println("ceiling(3): " + ns.ceiling(3));

        System.out.println("pollFirst(): " + ns.pollFirst());
        System.out.println("Navigable Set:  " + ns);

        System.out.println("pollLast(): " + ns.pollLast());
        System.out.println("Navigable Set:  " + ns);

        System.out.println("pollFirst(): " + ns.pollFirst());
        System.out.println("Navigable Set:  " + ns);

        System.out.println("pollFirst(): " + ns.pollFirst());
        System.out.println("Navigable Set:  " + ns);

        System.out.println("pollFirst(): " + ns.pollFirst());
        System.out.println("Navigable Set:  " + ns);

        System.out.println("pollFirst(): " + ns.pollFirst());
        System.out.println("pollLast(): " + ns.pollLast());

    }
}
