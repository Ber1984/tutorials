package com.erick.company.LeetCode.slidingwindows;

import java.util.HashMap;
import java.util.Map;

public class CountSubarray {
    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{1, 2, 3, 4, 5}, 10));
    }

    public static long countSubarrays(int[] nums, long k) {
        //0(1) //0(Log n)
        //Sliding windows = generate a windows for example subarrays and validate a contraint

        int n = nums.length;
        int left = 0;
        long sum = 0;
        long ans = 0;

        for (int right = 0; right < n; right++) {
            sum += nums[right];

            // Shrink the window if sum * window length >= k
            while (sum * (right - left + 1) >= k && left <= right) {
                sum -= nums[left];
                left++;
            }

            // All subarrays ending at right and starting from left to right are valid
            ans += (right - left + 1);
        }

        return ans;


    }
}
