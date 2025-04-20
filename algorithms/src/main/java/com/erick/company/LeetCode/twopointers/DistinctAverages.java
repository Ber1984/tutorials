package com.erick.company.LeetCode.twopointers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DistinctAverages {
    public static void main(String[] args) {
        System.out.println(distinctAverages(new int[]{4,1,4,0,3,5}));

        //1. Remove 0 and 5, and the average is (0 + 5) / 2 = 2.5. Now, nums = [4,1,4,3].
        //2. Remove 1 and 4. The average is (1 + 4) / 2 = 2.5, and nums = [4,3].
        //3. Remove 3 and 4, and the average is (3 + 4) / 2 = 3.5.
        //Since there are 2 distinct numbers among 2.5, 2.5, and 3.5, we return 2.
    }

    static public int distinctAverages(int[] nums) {
        Set<Integer> ans = new HashSet();
        Arrays.sort(nums);
        int start = 0, end = nums.length - 1;

        while(start < end) {
            if(nums[start] == nums[end]) {
                continue;
            }
            ans.add(nums[start] + nums[end]);
            start++; end--;
        }

        return ans.size();
    }
}
