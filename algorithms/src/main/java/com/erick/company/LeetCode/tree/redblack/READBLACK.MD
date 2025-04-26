A Red-Black Tree is a type of self-balancing binary search tree (BST) that ensures the tree remains balanced after insertions and deletions, keeping operations like search, insert, and delete in O(log n) time.

🔴⚫ What Makes a Tree a Red-Black Tree?
Each node in a Red-Black Tree follows these five key properties:

Each node is either red or black.

The root is always black.

All leaves (nulls or "NIL nodes") are black.

Red nodes cannot have red children (no two reds in a row).

Every path from a node to its descendant NIL nodes contains the same number of black nodes (called black-height).

These properties keep the tree roughly balanced, meaning the longest path from root to leaf is at most twice the shortest path. This guarantees performance.

✅ Why Use Red-Black Trees?
Guarantees O(log n) for insertion, deletion, and search.

Used in real-world systems, like:

Java’s TreeMap and TreeSet

Linux’s completely fair scheduler

Database indexing

Memory management subsystems

🔁 How It Balances?
Whenever an insertion or deletion violates one of the red-black properties, the tree performs:

Rotations (left or right)

Recoloring of nodes

This keeps the tree height balanced without requiring strict balancing like AVL trees.