package com.erick.company.LeetCode.backtracking;

public class minimumBeautifulSubstrings {

    public static void main(String[] args) {
        minimumBeautifulSubstrings("1011");
    }

    public static int minimumBeautifulSubstrings(String s) {
        int result = backtrack(s, 0);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private static int backtrack( String str, int start) {
        if (start == str.length()) { //base case
            return 0;
        }
        int minCount = Integer.MAX_VALUE;

        for (int end = start + 1; end <= str.length(); end++) {
            String substring = str.substring(start, end);
            if (substring.charAt(0) != '0' && isPowerOf5(Integer.parseInt(substring, 2))) { //constraints
                int count = backtrack(str, end);
                if (count != Integer.MAX_VALUE) {
                    minCount = Math.min(minCount, 1 + count);
                }
            }
        }
        return minCount;
    }

    private static boolean isPowerOf5(int num) {
        if (num <= 0) {
            return false;
        }

        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }
}
