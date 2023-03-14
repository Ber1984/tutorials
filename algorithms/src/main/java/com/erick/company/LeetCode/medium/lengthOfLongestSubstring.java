package com.erick.company.LeetCode.medium;

import java.util.HashSet;

public class lengthOfLongestSubstring {


    public static void main(String[] args) {
        String words = "pwwkew";
        System.out.println(lengthOfLongestSubstring("words"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int start = 0,end = 0,max = 0;
        HashSet<Character> set = new HashSet<>();
        while(end < s.length()){
            char letter = s.charAt(end);
            if(!set.contains(letter)){
                set.add(letter);
                end++;
                max = Math.max(set.size(), max);
            }  else {
                set.remove(s.charAt(start));
                start++;
            }
        }
        return max;
    }

}
