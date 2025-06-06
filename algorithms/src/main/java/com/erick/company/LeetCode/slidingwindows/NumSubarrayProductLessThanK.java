package com.erick.company.LeetCode.slidingwindows;

public class NumSubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //Sliding windows O(1)
        int  left = 0, ans = 0, prod = 1;

        for(int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while(prod >= k && left <= right) {
                //shrink multiples times
                prod /= nums[left];
                left++;
            }

            ans += (right - left + 1);
        }
        return ans;
    }
}
