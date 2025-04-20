package com.erick.company.LeetCode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList();
        backtrack(ans, new ArrayList(), nums, new boolean[nums.length]);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> tmpList, int[] nums, boolean[] used) {

        if(tmpList.size() == nums.length && !ans.contains(tmpList)) {
            ans.add(new ArrayList(tmpList));
            return;
        }

        //choices
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            tmpList.add(nums[i]);
            backtrack(ans, tmpList, nums, used);
            used[i] = false;
            tmpList.remove(tmpList.size() - 1);
        }

    }
}
