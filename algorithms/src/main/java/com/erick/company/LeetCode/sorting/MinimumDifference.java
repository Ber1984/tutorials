package com.erick.company.LeetCode.sorting;

import java.util.Arrays;

public class MinimumDifference {

    public static void main(String[] args) {
        //System.out.println(minimumDifference(new int[]{87063,61094,44530,21297,95857,93551,9918}, 6));
        //System.out.println(minimumDifference(new int[]{9,4,1,7}, 2));
        //System.out.println(minimumDifference(new int[]{90}, 1));
        System.out.println(minimumDifference2(new int[]{9,4,1,7}, 2));
    }

    public static int minimumDifference(int[] nums, int k) {

        if (k == 1)
            return 0;

        Arrays.sort(nums);

        int i = 0, j = k - 1,
                min = Integer.MAX_VALUE;

        while (j < nums.length) {
            min = Math.min(min, nums[j++] - nums[i++]);
        }

        return min;
    }

    public static int minimumDifference2(int[] nums, int k) {

        if (k == 1)
            return 0;

        int min = Integer.MAX_VALUE;
        int count = 0;
        if(count < k) {
            for(int i = 0; i < nums.length; i++) {
                int sum = 0;
                for(int j = i + 1; j < nums.length; j++) {
                        sum = nums[i] - nums[j];
                        min = Math.min(min, sum);
                        count++;
                }


            }
        }
        return min;
    }
}
