package com.erick.company.LeetCode.slidingwindows;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int i = 0, j = 1, max = Integer.MIN_VALUE;
        if (s.isEmpty())
            return 0;
        String tmpSubString = String.valueOf(s.charAt(0));

        while (i < s.length() && j < s.length()) {

            if (!tmpSubString.contains(String.valueOf(s.charAt(j)))) { // a b c
                tmpSubString += String.valueOf(s.charAt(j));
                j++;
            } else {
                max = Math.max(tmpSubString.length(), max);
                tmpSubString = "";
                i++;
                tmpSubString += String.valueOf(s.charAt(i));
                j = i + 1;
            }
        }
        return max;
    }
}
