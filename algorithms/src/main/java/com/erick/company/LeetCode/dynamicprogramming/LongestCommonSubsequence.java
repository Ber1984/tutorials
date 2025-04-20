package com.erick.company.LeetCode.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abc", "def"));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        // recursion
        // base case is not equal
        StringBuilder ans = new StringBuilder();
        return helper(text1, text2, ans, 0, 0, Integer.MIN_VALUE);
    }

    private static int helper(String text1, String text2, StringBuilder ans, int i, int j, int max) {
        if (j == text1.length()) {
            max = Math.max(ans.length(), max);
            ans.setLength(0);
            i++;
            j = i;
        }
        if (j > text1.length() - 1 && i == text1.length()) {
            return max;
        }
        if (text2.contains(String.valueOf(text1.charAt(j)))) { //
            ans.append(text1.charAt(j)); // a
        }
        return helper(text1, text2, ans, i, j + 1, max);
    }
}
