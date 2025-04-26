package com.erick.company.LeetCode.tree.algoritms.dfs;

import java.util.LinkedList;
import java.util.Queue;

public class MinimunDepthOfBinaryTree {
    private int min = Integer.MAX_VALUE;
    public static void main(String[] args) {

    }

    public int minDepth(TreeNode root) {
        if(root == null) return 0; // empty tree has depth 0
        dfs(root, 1); // Start level at 1 (root is depth 1)
        return min;
    }

    private void dfs(TreeNode current, int level) {
        if(current == null) return;

        if(current.left == null && current.right == null) {    // it's a leaf
            min = Math.min(min, level);
        }

        dfs(current.left, level + 1); //
        dfs(current.right,  level + 1); //
    }

    /* FIFO
using bfs to improve performance one i find a leaf return level

You chose BFS perfectly for finding minimum depth. Let me explain why:

Why BFS is best for Minimum Depth:
Minimum depth = shortest path from root to a leaf.

BFS (level order) visits the tree level by level.

So, the first time we find a leaf node (no left and no right child), we immediately know it's the minimum depth.

No need to explore deeper! (That's why we can return immediately!)

If you used DFS:
You might have to explore all paths to find minimum manually.

DFS would go deep into 2 → 4 unnecessarily before realizing 3 was closer.

Type | Best for
BFS | Find minimum depth (first leaf we reach)
DFS | Find maximum depth, full tree traversal, checking all paths


 Full Thought Process:
With BFS:

We add both left and right children to the queue (level by level).

Because BFS explores closest nodes first,

the first leaf we find (where left == null && right == null)

is guaranteed to be at the minimum depth.

So no need to check deeper subtrees!

We just return immediately when we find the first leaf.

📜 In short:
✅ BFS adds children →
✅ Children closer to root are explored first →
✅ First leaf found = minimum depth →
✅ Return immediately!
 */

    public int minDepthBfs(TreeNode root) {
        if (root == null) return 0; // Empty tree depth is 0

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); //O(1)
        int level = 1; //it's one because we have a root

        while (!queue.isEmpty()) {
            int queueSize = queue.size(); //i need this value because we'll change dynamically as a add new nodes

            for (int i = 0; i < queueSize; i++) { //my queue can have multiples nodes
                TreeNode current = queue.poll(); //remove the current node  //O(1)

                // Check if it's a leaf node because this node will be the nearest to the root - shortest path from root to a leaf.
                if (current.left == null && current.right == null) {
                    return level;
                }

                // Add children to queue
                if (current.left != null) queue.offer(current.left); //we validate tha the next node is not null and add it to the queue to keep iterating
                if (current.right != null) queue.offer(current.right);
            }

            level++; // move to next level after processing all nodes at current level
        }

        return level; // will never reach here because we always return when we find a leaf
    }
//Time complexity will be 0(1) and space complexity will also O(N)

    /*
    1. Time Complexity:
Even though poll() and offer() are O(1) operations on the queue,
you still need to traverse part of the tree until you find a leaf.

👉 Worst case:
If the tree is completely unbalanced (like a linked list),
or if the first leaf is deep down,
you might have to visit all nodes once.

✅ So time complexity is O(N), where N = number of nodes in the tree.

Important: Early return helps in practice (faster for shallow trees) but doesn't change worst-case complexity.
Because in worst-case, you still might have to touch every node before finding a leaf.


2. Space Complexity:
✅ Space complexity comes from the queue.

At any point, the queue might contain up to one full level of the tree.

In a balanced binary tree, the maximum number of nodes at the last level is about N/2.
Thus:

✅ Worst-case space complexity is O(N) in a very broad sense.

But:

✅ At most, you store all nodes in one level at a time (much smaller than total N).
     */

    /*
    Aspect | Complexity
       Time | O(N)
        Space | O(N) (at most one level)
     */
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val) {
        this.val = val;
    }
}

/*
notes
You initialize min = 0, but the minimum depth cannot be 0 unless the tree is empty!
➔ Better initialize min = Integer.MAX_VALUE.

You need to handle the empty tree case (root == null) directly in minDepth()

Key improvements:
Check current == null, not root == null.

Initialize min = Integer.MAX_VALUE.

Start from level = 1 when calling dfs(root, 1).

Handle root == null separately.

 */



