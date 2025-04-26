package com.erick.company.LeetCode.tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {

    public static void main(String[] args) {

        //        1
        //       / \
        //      2   3
        //     / \
        //    9   8

        /*
        TreeNode treeNode3 = new TreeNode(9);
        TreeNode treeNode4 = new TreeNode(8);
        TreeNode treeNode2 = new TreeNode(2, treeNode3, treeNode4); // left = 9, right = 8
        TreeNode treeNode5 = new TreeNode(3);    //  node 3 as right child of root
        TreeNode treeNode1 = new TreeNode(1, treeNode2,treeNode5); // root = 1

         */

        //       1
        //      / \
        //     2    3
      //      / \   /
      //     4   5  6

        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(3, treeNode6, null);
        TreeNode treeNode2 = new TreeNode(2, treeNode4, treeNode5);
      TreeNode rootNode = new TreeNode(1, treeNode2, treeNode3);


        bfs(rootNode);
    }

    //Depth first search = in - orders - pre - order - post - order left - root - right
    private List<Integer> inOrder(TreeNode node) {
        var ans = new ArrayList<Integer>();

        dfs(node,ans);
        return ans;
    }

    private static void dfs(TreeNode treeNode, List<Integer> ans) {
        if(treeNode == null) return; //base case

        dfs(treeNode.left, ans);
        ans.add(treeNode.val);
        dfs(treeNode.right,ans);
    }
    //Breadth first search = level Level-Order Traversal - Level by level top - down
    private static void bfs(TreeNode treeNode) {
        //stack mimic recursion call to do it iteratively
        var ans = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = treeNode;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr); //n(1)
                curr = curr.left;
            }

            //visit node
            curr = stack.pop(); //n(1)
            ans.add(curr.val);

            //move right pointer to iterate sub trees
            curr = curr.right;
        }

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        //root left - right
        List<Integer> ans = new ArrayList();
        if (root == null) return ans;
        //LIFO - Stack
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        //We use a stack (LIFO), so we push right first, then left. This ensures that left is processed        before right when popping.
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop(); //
            ans.add(node.val); // Root

            // Push right first so left is processed first
            if (node.right != null) {
                stack.push(node.right); // Right
            }

            if (node.left != null) {
                stack.push(node.left);  // Left
            }
        }
        return ans;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        //post order - left right root
        List<Integer> ans = new ArrayList();

        bfs(root, ans);
        return ans;

    }

    private void bfs(TreeNode root, List<Integer> ans) {
        if(root == null) return;

        bfs(root.left, ans);
        bfs(root.right, ans);
        ans.add(root.val);
    }

    //Instead of reversing at the end, we directly insert each visited node at the beginning of the result list: result.add(0, node.val);
    /*
          1
        / \
       2   3

       Push 1
Pop 1 → insert at front → [1]
Push 2, Push 3
Pop 3 → insert at front → [3,1]
Pop 2 → insert at front → [2,3,1]

     */



    public static List<Integer> postorderTraversalIteractivly(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(0, node.val); // Add to the front of the list

            if(node.left != null) {
                stack.push(node.left);
            }
            if(node.right != null) {
                stack.push(node.right);
            }
        }

        return result;

    }

    /*
    Find height of a binary tree
     */
    int maxHeight = 0; //is a class-level field that tracks the deepest depth seen so far.
    private void findHeight(TreeNode node) {
        int ans = 0;

        dfsFindHeight(node,0); //We pass currentHeight (starting at 0) and increase it as we go deeper.
        System.out.println("height" + ans);
    }

    private void dfsFindHeight(TreeNode node, int currentHeight) {
        //post order = left right root
        if(node == null) return;

        if(node.left == null && node.right == null) { //leaf
            maxHeight = Math.max(maxHeight, currentHeight); //When we hit a leaf node, we compare and update maxHeight.
        }

        dfsFindHeight(node.left, currentHeight + 1);
        dfsFindHeight(node.right, currentHeight + 1);

    }

    //Print all root-to-leaf paths using recursion

    public void printAllPaths(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        dfsPaths(root, path);
    }

    private void dfsPaths(TreeNode node, List<Integer> path) {
        if (node == null) return;

        // Add current node to the path
        path.add(node.val);

        // If it's a leaf, print the path
        if (node.left == null && node.right == null) {
            System.out.println(path);
        }

        // Continue to left and right children
        dfsPaths(node.left, path);
        dfsPaths(node.right, path);

        // Backtrack
        path.remove(path.size() - 1);
    }

    //To Print the Longest Path Only:

    private List<Integer> longestPath = new ArrayList<>();

    public void printLongestPath(TreeNode root) {
        List<Integer> currentPath = new ArrayList<>();
        dfsLongestPath(root, currentPath);
        System.out.println("Longest Path: " + longestPath);
    }

    private void dfsLongestPath(TreeNode node, List<Integer> currentPath) {
        if (node == null) return;

        currentPath.add(node.val);

        if (node.left == null && node.right == null) {
            if (currentPath.size() > longestPath.size()) {
                longestPath = new ArrayList<>(currentPath); // copy current path
            }
        }

        dfsLongestPath(node.left, currentPath);
        dfsLongestPath(node.right, currentPath);

        currentPath.remove(currentPath.size() - 1); // backtrack
    }


    /*
        check if a binary tree is balanced
     */
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode node) {
        if (node == null) return 0; //return 0 if node is null because the height of a null node is 0

        int left = checkHeight(node.left);  //iterate through each left sub tree and return its height
        if (left == -1) return -1; //return -1 because sub tree is unbalanced

        int right = checkHeight(node.right);  //iterate through each right sub tree and return its height
        if (right == -1) return -1; //return -1 because sub tree is unbalanced

        if (Math.abs(left - right) > 1) return -1;  //operate the difference h =   height  left subtree -  height right subtree > 1

        return Math.max(left, right) + 1; // return height
        /*
        Math.max(left, right): You want the longest path to a leaf node from the current node.
        So you compare the height of the left subtree vs height of the right subtree.

        + 1 :
            You add 1 because you’re including the current node in the count.
            Remember, height is "number of edges from current node to the deepest leaf".
            f you're counting nodes instead of edges, the base case usually returns 0 instead of -1.
         */
    }


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
