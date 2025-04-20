package com.erick.company.LeetCode.dynamicprogramming;

public class Tribonacci {
    public static void main(String[] args) {
        System.out.println(tribonacci(25));
    }

    public static int tribonacci(int n) {
        //T_3 = 0 + 1 + 1 = 2
        //T_4 = 1 + 1 + 2 = 4
        //T_5 = 1 + 1 + 2 + 4 = 8
        boolean isFound = true;
        int[] dp = new int[1];
        dp[0] = 2;
        int i = 2;
        while(i <= n) {
            int sum = dp[0] + dp[0]; //4 + 4
            if(sum == n ) { //2
                return sum;
            }
            dp[0] = sum; //4
            i++;
        }
        return -1;

    }
}
