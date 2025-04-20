package com.erick.company.LeetCode.strings;

public class IsPrefixString {
    public static void main(String[] args) {
        System.out.println(isPrefixString("iloveleetcode", new String[]{"i","love","leetcode","apples"}));
        System.out.println(isPrefixString("ccccccccc", new String[]{"c","cc"}));
    }

    public static boolean isPrefixString(String s, String[] words) {
        for(String word : words) { //i
            if(!s.startsWith(word)){
                return false;
            }
            s = s.substring(word.length());
            if(s.isEmpty()) return true;
        }
        return s.isEmpty();
    }
}
