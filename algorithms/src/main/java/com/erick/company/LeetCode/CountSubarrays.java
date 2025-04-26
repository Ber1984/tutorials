package com.erick.company.LeetCode;

import java.util.Arrays;

public class CountSubarrays {

    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{1,3,5,2,7,5}, 1, 5));
        System.out.println(countSubarrays(new int[]{1,1,1,1}, 1, 1));
    }

    public static long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0L;
        int start = 0, end = 0;

        while (start < nums.length) {
                int[] arrayRange = Arrays.copyOfRange(nums, end, start + 1);
                Arrays.sort(arrayRange);

                if(start < arrayRange.length && arrayRange[0] == minK && arrayRange[arrayRange.length - 1] == maxK) {
                    ans++;
                }

            start++;
            if(start > nums.length - 1) {
                ++end;
                start = end;
            }
        }

        return ans;

    }
}
