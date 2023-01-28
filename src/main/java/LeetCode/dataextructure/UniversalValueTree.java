package LeetCode.dataextructure;


import java.util.List;

public class UniversalValueTree {
    public static void main(String[] args) {
        /*
         is a tree where all nodes have the same value.
         */
        addNodes(List.of(1, 1, 1, 1, 1, 1, 1));
        System.out.println(isUnivalTree(new TreeNode()));
    }

    public static boolean isUnivalTree(TreeNode root) {
        return is_unival(root);
    }

    private static boolean is_unival(TreeNode root) {
        if (root == null) return true;
        if (root.left != null && root.left.val != root.val) return false;
        if (root.right != null && root.right.val != root.val) return false;
        if (is_unival(root.left) && is_unival(root.right)) return true;
        return false;
    }

    private static TreeNode addNodes(List<Integer> nums) {
        int i = 0;
        int j = i + 1;
        int k = j + 1;
        TreeNode node = null;
        while (i < nums.size() - 1) {

            if (j < k) {
                node = new TreeNode(nums.get(i), new TreeNode(nums.get(j)), new TreeNode(nums.get(k)));
                i++;
            }

        }
        return node;

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
    }
}

