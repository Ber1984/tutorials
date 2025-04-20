package com.erick.company.LeetCode.dynamicprogramming;

public class FibonacciSequence {

    public static void main(String[] args) {
        // 1 1 2 3 5 8 13 n = 20
        int n = 20;
        int[] dp = new int[n + 1]; // Memoization array initialized to 0
        System.out.println(fibonacci(20, dp));
        int[] tab = new int[n + 1];
        tab[1] = 1;
        tab[2] = 1;
        System.out.println(fibonacci2(20, tab));
    }

    private static int fibonacci(int n, int[] dp) {
        if (n == 1 || n == 2) {
            return 1;  // Base case: F(1) = 1, F(2) = 1
        }
        if (dp[n] != 0) {
            return dp[n];  // Return cached result if it exists
        }
        // Recursively calculate Fibonacci numbers
        dp[n] = fibonacci(n - 1, dp) + fibonacci(n - 2, dp);
        return dp[n];  // Store and return result
    }

    private static int fibonacci2(int n, int[] tab) { //Bottom-up approach - tabulation
        if (tab[n] == 1 || tab[n] == 2) {
            return 1;  // Base case: F(1) = 1, F(2) = 1
        }
        int i = 2;
        while(i <= n) {
           tab[i] = tab[i - 2] + tab[i - 1];
           i++;
        }

        return tab[n];
    }
}
