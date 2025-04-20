package com.erick.company.LeetCode.dynamicprogramming;

public class MaxCompatibilitySum {
    static int max;

    public static void main(String[] args) {
        System.out.println(maxCompatibilitySum(new int[][]{{1,1,0},{1,0,1},{0,0,1}}, new int[][]{{1,0,0},{0,0,1},{1,1,0}}));
    }
    public static int maxCompatibilitySum(int[][] students, int[][] mentors) {
        boolean[] visited = new boolean[students.length];
        helper(visited, students, mentors, 0, 0);
        return max;
    }

    public static void helper(boolean[] visited, int[][] students, int[][] mentors, int pos, int score) {
        if (pos >= students.length) {
            max = Math.max(max, score);
            return;
        }
        for (int i = 0; i < mentors.length; i++)
            if (!visited[i]) {
                visited[i] = true;
                helper(visited, students, mentors, pos + 1, score + score(students[pos], mentors[i]));
                visited[i] = false;
            }
    }

    public static int score(int[] a, int[] b) {
        int count = 0;

        for (int i = 0; i < b.length; i++)
            if (a[i] == b[i])
                count += 1;
        return count;
    }

}


