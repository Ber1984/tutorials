package com.erick.company.LeetCode.binarysearch;

import java.util.Arrays;

public class LongestSubsequenceWithLimitedSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(answerQueries(new int[]{4,5,2,1}, new int[]{3,10,21})));
    }

    public static int[] answerQueries(int[] A, int[] queries) {
        Arrays.sort(A);
        int n = A.length, m = queries.length, res[] = new int[m]; //ok
        for (int i = 1; i < n; ++i)
            A[i] += A[i - 1];
        for (int i = 0; i < m; ++i) {
            int j = Arrays.binarySearch(A, queries[i]);
            res[i] = Math.abs(j + 1);
        }

        return res;
    }
}
