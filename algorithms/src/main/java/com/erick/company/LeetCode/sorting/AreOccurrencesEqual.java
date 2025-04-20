package com.erick.company.LeetCode.sorting;

import java.util.HashMap;
import java.util.Map;

public class AreOccurrencesEqual {
    public static void main(String[] args) {
        System.out.println(areOccurrencesEqual("aaabb"));
    }

    public static boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> map = new HashMap();
        for(char ch : s.toCharArray()) map.put(ch, map.getOrDefault(ch, 0) + 1);
        int min = Integer.MAX_VALUE;
        boolean ans = false;
        for(int num : map.values()) {
            if(num < min){
                return false;
            } else {
            }
        }
        return true;
    }
}
