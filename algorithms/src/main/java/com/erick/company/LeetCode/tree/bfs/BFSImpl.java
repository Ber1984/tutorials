package com.erick.company.LeetCode.tree.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSImpl {
    public static void main(String[] args) {

        TreeNode treeNode5 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(15);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(20, treeNode6, treeNode5);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode rootNode = new TreeNode(3, treeNode2, treeNode3);

        System.out.println(bfs(rootNode));
    }

    /*
    Good news: your idea is solid (using BFS with a Queue, and grouping nodes level by level).
     */
    private static List<List<Integer>> bfs(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (node == null) return ans; // handle null root
        queue.offer(node); //add root to the queue

        while (!queue.isEmpty()) {
            TreeNode current;
            int queueSize = queue.size();
            ArrayList<Integer> levels = new ArrayList<>();
            for (int i = 0; i < queueSize; i++){ //This is wrong because queue.size() is dynamic, changing as you offer() new nodes! //O(n)
                current = queue.poll();
                if(current != null) {
                    levels.add(current.val); //add my nice nodes
                    queue.offer(current.left);
                    queue.offer(current.right);
                }
            }
            if(!levels.isEmpty()) {
                ans.add(levels);
            }

        }
         return ans;
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

