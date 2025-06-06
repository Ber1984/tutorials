package com.erick.company.LeetCode.prefixsum;

public class PrefixSum {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        int n = arr.length;
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i]; //1 + 2
        }

        /*
         arr = [3, 2, 4, 5, 1]
         prefix = [3, 5, 9, 14, 15];

         Sum of subarray [1..3] (i.e., 2 + 4 + 5):
         sum = prefix[3] - prefix[0] = 14 - 3 = 11
         */


    }
}
