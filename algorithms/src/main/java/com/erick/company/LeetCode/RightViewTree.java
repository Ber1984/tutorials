package com.erick.company.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewTree {
    public static void main(String[] args) {

    }
        void printRightView(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = queue.poll();
                    if (i == levelSize - 1) System.out.println(node.val);
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
            }
        }
                 List<Integer> rightView = new ArrayList<>();

                public List<Integer> rightSideView(TreeNode root) {
                    rightView.clear();
                    dfs(root, 0);
                    return rightView;
                }

                private void dfs(TreeNode node, int level) {
                    if (node == null) return;

                    if (level == rightView.size()) {
                        // First node we visit at this level → rightmost one
                        rightView.add(node.val);
                    }

                    // Visit right first, then left
                    dfs(node.right, level + 1);
                    dfs(node.left, level + 1);
                }


    public void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                System.out.print(current.val + " ");
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
            System.out.println(); // Move to next line for each level
        }
    }

    /*
         Key Point:
        The depth here is just a counter passed as a parameter in recursion.
        You start with dfs(root, 0).
        It increases as you go deeper into the tree.
     */
    /*private void dfs(TreeNode node, int depth) {
        if (node == null) return;

        // Do something at current depth
        System.out.println("Value: " + node.val + ", Depth: " + depth);

        // Move to next level
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }*/

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

    }
}



