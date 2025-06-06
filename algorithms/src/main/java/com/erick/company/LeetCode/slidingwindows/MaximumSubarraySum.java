package com.erick.company.LeetCode.slidingwindows;

import java.util.HashSet;
import java.util.Set;

public class MaximumSubarraySum {

    public static void main(String[] args) {
        System.out.println(maximumSubarraySum(new int[]{1,5,4,2,9,9,9}, 3));
    }

    public static long maximumSubarraySum(int[] nums, int k) {
        //1 5 4 2 9
        Set<Integer> seen = new HashSet<>();//unique values
        int left = 0, right = 0; //sliding window regular pointers
        long ans = 0, sum = 0;

        while (right < nums.length) { //expand the window
            int num = nums[right];

            while (seen.contains(num)) { //we handle duplicate If we detect a duplicate, we shrink the window from the left until the duplicate is removed.
                seen.remove(nums[left]);
                sum -= nums[left];
                left++;
            }

            seen.add(num); //add numbers for uniqueness
            sum += num; //adding values to the current sum

            // If window size == k, try to update max and shrink window
            if (right - left + 1 == k) { //contraint
                ans = Math.max(ans, sum); //update max

                // Remove left to slide window - shrink
                sum -= nums[left]; // remove  position 0 in the array which is 1
                seen.remove(nums[left]); //remove current values from set
                left++;
            }

            right++;
        }

        return ans;
    }
}
