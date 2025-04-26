package com.erick.company.LeetCode.tree.redblack.treeset;

/*
In Java, TreeSet is a class that implements the SortedSet interface. SortedSet is an interface that extends the Set interface, guaranteeing that elements are stored in a sorted order, either by their natural ordering or by a custom Comparator. TreeSet provides a concrete implementation of SortedSet using a tree data structure (specifically, a red-black tree), which ensures the elements are always sorted.
 */

import java.util.*;

/*
Key characteristics of TreeSet:
Sorted Order: Elements are stored in ascending order by default (natural ordering) or based on a provided Comparator.
No Duplicates: Like any Set, TreeSet does not allow duplicate elements.
Efficient Operations: add(), remove(), and contains() operations have a time complexity of O(log n), where n is the number of elements.
Not Thread-Safe: TreeSet is not thread-safe and requires external synchronization for concurrent access.
No Null Elements: It does not allow null elements.
 */
public class TreeSetImpl {

    public static void main(String[] args) {
        TreeSet<Integer> treSet = new TreeSet<>();
        List<Integer> integers = new ArrayList<>();
        integers.add(9);
        treSet.add(3);
        treSet.add(1);
        treSet.add(2);
        treSet.addAll(integers);

        System.out.println("Natural ordering: " + treSet); // Output: [1, 2, 3]

        // Using a custom Comparator (strings, reverse order)
        SortedSet<String> names = new TreeSet<>(Comparator.reverseOrder());
        names.add("Charlie");
        names.add("Alice");
        names.add("Bob");
        System.out.println("Reverse order: " + names); // Output: [Charlie, Bob, Alice]

        // Traversing elements via help of iterators
        Iterator<String> itr = names.iterator();

        // Holds true until there is element remaining in object
        while (itr.hasNext()) {

            // Moving onto next element with help of next() method
            System.out.println(itr.next());
        }

        //        SortedSet<String> ts = new TreeSet<String>();
        SortedSet<String> ts = new TreeSet<>();
        ts.add("");


        //Navigable Set
        NavigableSet<Integer> nv = new TreeSet<>();
    }
}

