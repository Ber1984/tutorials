package com.erick.company.LeetCode.dynamicprogramming;

import java.util.Arrays;

public class MaxTaxiEarnings {
    public static void main(String[] args) {
        System.out.println(maxTaxiEarnings(5, new int[][]{{2,5,4},{1,5,1}}));
    }

    public static long maxTaxiEarnings(int n, int[][] A) {
        Arrays.sort(A, (a, b) -> a[0] - b[0]);
        long[] dp = new long[n + 1];
        int j = 0;
        for(int i = 1; i <= n; ++i) {
            dp[i] = Math.max(dp[i], dp[i - 1]);
            while (j < A.length && A[j][0] == i) {
                dp[A[j][1]] = Math.max(dp[A[j][1]], dp[i] + A[j][1] - A[j][0] + A[j][2]);
                ++j;
            }
        }
        return dp[n];
    }
}
