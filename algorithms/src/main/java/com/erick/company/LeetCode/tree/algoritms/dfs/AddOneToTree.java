package com.erick.company.LeetCode.tree.algoritms.dfs;

public class AddOneToTree {

    public static void main(String[] args) {

    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        //count the depth of the tree and when we find the target depth
        //add a node
        //root - left - right - pre-order

        if (depth == 1) {
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            return newNode;
        }

        dfs(root, val, depth, 1);
        return root;
    }

    /*
   We use void in the method because we’re modifying the tree in-place. we're modififien the current referece of the tree
   */
    private void dfs(TreeNode curr, int val, int depth, int currentDepth) {
        if (curr == null)
            return;
        //4
        if (currentDepth == depth - 1) {
            TreeNode rightNode = curr.right; //2
            TreeNode leftNode = curr.left; //6
            curr.left = new TreeNode(val); //assign new node as a child
            curr.left.left = leftNode;

            curr.right = new TreeNode(val); //1
            curr.right.right = rightNode;
        } else {
            dfs(curr.left, val, depth, currentDepth + 1);
            dfs(curr.right, val, depth, currentDepth + 1);
        }

    }
}
