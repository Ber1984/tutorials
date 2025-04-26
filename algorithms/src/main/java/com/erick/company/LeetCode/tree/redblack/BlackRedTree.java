package com.erick.company.LeetCode.tree.redblack;

public class BlackRedTree {

    /*
    A Red-Black Tree is a self-balancing binary search tree where each node has an additional attribute: a color,
    which can be either red or black. The primary objective of these trees is
    to maintain balance during insertions and deletions,
    ensuring efficient data retrieval and manipulation. o(log n)
     */

    /*
    The Red-Black Tree in above image ensures that every path from the root to a leaf node has the same number of black nodes. In this case,​ there is one (excluding the root node).

Advantages of Balanced Binary Tree:
Balanced binary trees, such as AVL trees and Red-Black trees, maintain their height in logarithmic proportion to the number of nodes. This ensures that fundamental operations like insertion, deletion, and search are executed with O(log n) time complexity.
Non Destructive In a balanced binary tree are performed in such a way that the tree remains balanced without requiring a complete reorganization.
Balanced binary trees are well-suited for range queries, where you need to find all elements within a specified range.
     */

    public static void main(String[] args) {
        //A Red-Black Tree is a type of self-balancing binary search tree (BST) that ensures the tree remains balanced after insertions and deletions, keeping operations like search, insert, and delete in O(log n) time.
/*
Each node in a Red-Black Tree follows these five key properties:

Each node is either red or black.

The root is always black.

All leaves (nulls or "NIL nodes") are black.

Red nodes cannot have red children (no two reds in a row).

Every path from a node to its descendant NIL nodes contains the same number of black nodes (called black-height).

These properties keep the tree roughly balanced, meaning the longest path from root to leaf is at most twice the shortest path. This guarantees performance.
 */

        //TreeMap - SortedMap - TreeSet -> SortedSet

        

    }
}
