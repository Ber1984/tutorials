package com.erick.company.LeetCode.dynamicprogramming;

public class CountBits {

    public static void main(String[] args) {
    //0 --> 0
        // 1 --> 1
        //2 --> 10
        //3 --> 11
    }
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i / 2] + (i % 2); // Memoization: Use previously computed results 1 + 1 = 2

        }
        return ans;
    }
}
