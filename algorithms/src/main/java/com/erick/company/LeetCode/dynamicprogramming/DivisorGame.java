package com.erick.company.LeetCode.dynamicprogramming;

import java.util.Arrays;

public class DivisorGame {

    public static void main(String[] args) {
        System.out.println(divisorGame(2));
    }

    public static boolean divisorGame(int n) {
        // 0
        // n 0 1 2
        // n 0 1
        int[] dp = new int[n]; // 1 1
        int choose = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) { // 0 1 2
                if (0 < j && j < n && n % j == 0) {
                    if (dp[j] == j) { // 1 == 1
                        dp[j] = 0;
                        n = n - j; // 1 0 - 1
                        break;
                    }
                    n = n - j; // 1 0 - 1
                    dp[j] = j; // 0 = 1
                    break;
                }
            }
        }

        System.out.print(Arrays.toString(dp));
        return true;
    }
}
