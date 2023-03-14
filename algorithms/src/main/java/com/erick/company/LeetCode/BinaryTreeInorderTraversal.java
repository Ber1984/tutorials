package com.erick.company.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        /*
         Recursively way
        */
        in_order(new TreeNode(), List.of(1, null, 2, 3));
    }

    private static List<Integer> in_order(TreeNode root, List<Integer> list) {
        if (root == null) return list;
        list = in_order(root.left, list);
        list.add(root.val);
        return in_order(root.right, list);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return res;
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            res.add(current.val);
            current = current.right;
        }

        return res;
    }


}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}



