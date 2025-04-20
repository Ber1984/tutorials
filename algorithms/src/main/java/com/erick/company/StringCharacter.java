package com.erick.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class StringCharacter {

    public static void main(String[] args) {
        String str = "aaabbbbbbcdrrrr";
        int[] frequencies = new int[26];

        for(int i = 0; i < str.length(); i++) {
            frequencies[str.charAt(i) - 'a']++;
        }

        System.out.println(Arrays.toString(frequencies));
         int max = Integer.MIN_VALUE;

        for(int i = 0; i < str.length(); i++) {
            if(frequencies[str.charAt(i) - 'a'] > 0) {
                System.out.println("here");
                int freq = frequencies[str.charAt(i) - 'a'];
                if(freq > max) max = freq;
                frequencies[str.charAt(i) - 'a'] = 0;
            }

        }

        System.out.println(max);
        var map = new HashMap<Character, Integer>();
        for(char ch : str.toCharArray()) map.put(ch, map.getOrDefault(ch, 0)+ 1);
        System.out.println(   Collections.max(map.values()));

    }
}
