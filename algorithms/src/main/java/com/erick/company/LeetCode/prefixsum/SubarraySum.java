package com.erick.company.LeetCode.prefixsum;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,1,1}, 2));
    }

    public static int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // Initialize with sum 0 occurring once
        int sum = 0, ans = 0;

        for (int num : nums) {
            sum += num;

            // Check if there is a prefix sum that, when removed, leaves sum = k
            ans += prefixSumCount.getOrDefault(sum - k, 0);

            // Record the current prefix sum
            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        }

        return ans;


    }
}
