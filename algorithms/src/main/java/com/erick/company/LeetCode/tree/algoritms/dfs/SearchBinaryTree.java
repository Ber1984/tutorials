package com.erick.company.LeetCode.tree.algoritms.dfs;


import com.sun.source.tree.Tree;

import java.util.Stack;

/*
Key Improvements and Corrections:
Method Name: Renamed bfs to dfs to better reflect its behavior as a depth-first search.

Recursive Return Handling: The method now properly returns the found node instead of always returning null.

Early Return Logic: If the node is found in the left subtree, it immediately returns the node without checking the right subtree.

Would you like further explanations or optimizations?
 */
public class SearchBinaryTree {

    public static void main(String[] args) {
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode5 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2, treeNode4, treeNode5);
        TreeNode rootNode = new TreeNode(4, treeNode2, treeNode7);


        //System.out.println(searchBST(rootNode, 2));
        System.out.println(usingStack(rootNode, 2));
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        // If such a node does not exist, return null.   O(log n)

        //pre - order we're root left - right DFS (DEPTH - FIRST - SEARCH ) - BREATH - FISRT - SEARCH
        return dfs(root, val);

    }

    private static TreeNode dfs(TreeNode root, int val) {
        if (root == null)
            return null;

        if (root.val == val)
            return root; //root

        //  Search the left subtree

        /*
        ✅ Why Handle Recursive Calls?
        In your original implementation, the recursive calls to bfs(root.left, val) and bfs(root.right, val) were not assigned to any variable, and their results were not returned. Thus, even if a matching node was found in the left or right subtree, that information was lost.
         */
        TreeNode leftResult = dfs(root.left, val); // left
        if(leftResult != null) {
            return leftResult; // Early return if the node is found in the left subtree
        }


        /* another way of returning
        TreeNode rightResult = dfs(root.right, val); // right
return rightResult; // Return the result of the right subtree search
         */
        // Otherwise, search the right subtree
        return dfs(root.right, val); //right;
    }

    private static TreeNode usingStack(TreeNode root, int val) {
        //I'm going to simulate the recursive stack using stack from JVM
        Stack<TreeNode> stack = new Stack<>(); //LIFO
        //pre-order traversal
        stack.push(root); //Time Complexity: O(1),
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop(); //Time Complexity: O(1), I
            //current stack is 2
            if (pop != null) { //hanlde root is null return root in a recursion called
                //current stack is 2
                if (pop.val == val)
                    return pop;
                stack.push(pop.right);
                stack.push(pop.left);
            }
        }
        return null;


        /*
        Performance analysis
        You are simulating the call stack using a Stack<TreeNode> to perform a pre-order traversal (Root → Left → Right).
        You push the root node first, then process it in a LIFO manner.
        If the current node is not null and its value matches the target value, you return it.

        Otherwise, you push the right child first, then the left child, ensuring that the left child is processed first when popped (mimicking pre-order traversal).

         Time Complexity: O(n)
         In the worst case, we need to visit every node once to find the target node, leading to O(n) time complexity, where n is the number of nodes in the tree.

         Space Complexity: O(n)
          In the worst case, the stack could hold all nodes at once, particularly when the tree is highly unbalanced (e.g., a skewed tree).

         Worst Case (Unbalanced Tree): The tree is effectively a linked list, and the stack could hold n nodes at once.

         
         */
    }

static class TreeNode {
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
}

