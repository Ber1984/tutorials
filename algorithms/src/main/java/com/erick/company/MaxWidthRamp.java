package com.erick.company;

import java.util.Arrays;

public class MaxWidthRamp {
    public static void main(String[] args) {
        System.out.println(maxWidthRamp(new int[]{6,0,8,2,1,5}));
    }

    public static int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Integer[] indices = new Integer[n];

        // Initialize the array with indices
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Sort indices based on corresponding values in nums and ensure stability
        Arrays.sort(indices, (i, j) ->
                nums[i] != nums[j] ? nums[i] - nums[j] : i - j
        );

        int minIndex = n; // Minimum index encountered so far
        int maxWidth = 0;

        // Calculate maximum width ramp
        for (int i : indices) {
            maxWidth = Math.max(maxWidth, i - minIndex);
            minIndex = Math.min(minIndex, i);
        }

        return maxWidth;
    }
}
