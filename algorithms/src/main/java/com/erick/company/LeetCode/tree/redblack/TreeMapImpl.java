package com.erick.company.LeetCode.tree.redblack;

import java.util.Comparator;
import java.util.TreeMap;

/*
A TreeMap in Java is an implementation of the Map interface that stores key-value pairs in a sorted order, based on the keys. It uses a red-black tree data structure, which ensures that the elements are always sorted. Here is some information about TreeMap:
 */
public class TreeMapImpl {
    public static void main(String[] args) {
        // Creating a TreeMap with natural ordering of keys (String)
        TreeMap<String, Integer> treeMap1 = new TreeMap<>();
        treeMap1.put("apple", 1);
        treeMap1.put("banana", 2);
        treeMap1.put("cherry", 3);
        System.out.println("TreeMap with natural ordering: " + treeMap1);

        // Creating a TreeMap with a custom Comparator (reverse order of String)
        TreeMap<String, Integer> treeMap2 = new TreeMap<>(Comparator.reverseOrder());
        treeMap2.put("apple", 1);
        treeMap2.put("banana", 2);
        treeMap2.put("cherry", 3);
        System.out.println("TreeMap with custom Comparator: " + treeMap2);
    }
}
