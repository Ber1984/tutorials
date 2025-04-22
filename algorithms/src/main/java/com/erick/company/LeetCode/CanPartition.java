package com.erick.company.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class CanPartition {
    public static void main(String[] args) {
        //System.out.println(canPartition(new int[]{1,5,11,5}));
        System.out.println(canPartition2(new int[]{1,5,11,5}));
    }

    public static boolean canPartition(int[] nums) {
        //Create subset of this nums
        //make sure that we can find at least one to return true.

        //greater number = 11
        //sum of this is 22 - 11 = 11
        //find a number that sum this target but avoid max
        int total = 0;
        for (int num : nums) total += num;
        if (total % 2 != 0) return false;

        int target = total / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }

        return dp[target];

    }

    //using a set
    private static boolean canPartition2(int[] nums) {
        int total = 0;
        for (int num : nums) total += num;
        if (total % 2 != 0) return false;
        int target = total / 2;
        Set<Integer> dp = new HashSet<>();
        dp.add(0);
        for(int num : nums) { //1,5
            Set<Integer> nextDp = new HashSet<>(dp); // copy current state
            for(int num1 : dp) {
                int newSum = num1 + num;
                if (newSum == target) return true; // early exit
                nextDp.add(newSum);
            }
            dp = nextDp;
        }


       return dp.contains(total / 2);
    }
}
