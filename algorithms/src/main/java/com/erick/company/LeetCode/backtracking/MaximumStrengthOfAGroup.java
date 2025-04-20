package com.erick.company.LeetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class MaximumStrengthOfAGroup {

    public static void main(String[] args) {
        System.out.println(maxStrength(new int[]{3,-1,-5,2,5,-9}));
    }
    public static void solve(List<List<Integer>> ans, int i, List<Integer> v, int[] nums) {
        if (i >= nums.length) { //base case
            ans.add(new ArrayList<>(v));  // Add a copy of the current subset
            return;
        }

        // Include nums[i] in the current subset
        v.add(nums[i]);
        solve(ans, i + 1, v, nums);

        // Backtrack: remove nums[i] and move on to the next element
        v.remove(v.size() - 1);
        solve(ans, i + 1, v, nums);
    }

    public static long maxStrength(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        long ans = Long.MIN_VALUE;
        solve(subsets, 0, new ArrayList<>(), nums);

        for (List<Integer> subset : subsets) {
            if (subset.isEmpty()) continue;

            long prod = subset.get(0);
            for (int j = 1; j < subset.size(); j++) {
                prod *= subset.get(j);
            }
            ans = Math.max(ans, prod);
        }

        return ans;
    }
}
