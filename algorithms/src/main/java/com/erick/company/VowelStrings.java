package com.erick.company;

import java.util.Arrays;

public class VowelStrings {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(vowelStrings(new String[]{"aba","bcb","ece","aa","e"}, new int[][]{{0,2},{1, 4},{1,1}})));
    }

    public static int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefixSum = new int[n + 1];

        // Precompute the prefix sum for words starting and ending with vowels
        for (int i = 0; i < n; i++) {
            if (isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length() - 1))) {
                prefixSum[i + 1] = prefixSum[i] + 1;
            } else {
                prefixSum[i + 1] = prefixSum[i];
            }
        }

        // Answer each query using the prefix sum
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            ans[i] = prefixSum[end + 1] - prefixSum[start];
        }

        return ans;
    }

    private static boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) != -1;

    }
}
