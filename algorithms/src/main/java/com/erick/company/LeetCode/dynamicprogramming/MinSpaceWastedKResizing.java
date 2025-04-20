package com.erick.company.LeetCode.dynamicprogramming;

public class MinSpaceWastedKResizing {

    static int ans = 0;

    public static void main(String[] args) {
        System.out.println(minSpaceWastedKResizing(new int[]{10,20}, 0));
    }
    public static int minSpaceWastedKResizing(int[] nums, int k) {
        Boolean[] dp = new Boolean[nums.length];
        helper(nums, k,dp, 0);
        return ans;
    }

    private static void helper(int[] nums, int k, Boolean[] visited, int start ) {
        //base case
        if(start > nums.length) {
            return;
        }
        for(int i = start; i < nums.length; i++) {
            visited[i] = true; //true, false
            int found = foundNumber(nums, nums[i], i + 1);
            if( found > 0) {
                //ans[i] = found; //
            }
            visited[i] = false;
            helper(nums, k, visited, start + 1);
        }
    }

    private static int foundNumber(int[] nums, int num, int pos) {

        for(int i = pos; i < nums.length;i++) {
            if(nums[i] >= num) return nums[i];
        }
        return -1;
    }

}
