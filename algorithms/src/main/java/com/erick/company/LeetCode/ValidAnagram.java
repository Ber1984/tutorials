package com.erick.company.LeetCode;

import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }
    public static boolean isAnagram(String s, String t) {

        Arrays.sort( s.toCharArray());
        Arrays.sort(t.toCharArray());

        return Arrays.equals(s.toCharArray(),t.toCharArray());
        }

}

