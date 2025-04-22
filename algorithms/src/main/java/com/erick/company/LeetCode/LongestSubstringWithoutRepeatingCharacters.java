package com.erick.company.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(answer("PWWKEW"));
    }

    private static int answer(String word) {
        int max = 0, i = 0, j = 0; //windowLength = i - j + 1
        Set<Character> seen = new HashSet<>(); //avoid duplicates

        while (i < word.length()) {
            if(!seen.contains(word.charAt(i))) { //P
                seen.add(word.charAt(i++)); //P
                max = Math.max(max, i - j);
            } else {
                seen.remove(word.charAt(j++));
            }
        }

         return max;
    }
}
