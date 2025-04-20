package com.erick.company;

import java.util.HashMap;
import java.util.Map;

public class CheckDistances {
    public static void main(String[] args) {
        System.out.println(checkDistances("aa", new int[]{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
    }

    public static boolean checkDistances(String s, int[] distance) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Integer, Character> ch = new HashMap<>();
        for (int i = 0; i < s.length() - 1; i++) {
            int gap = 0;
            if (!map.containsKey(s.charAt(i))) {
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        map.put(s.charAt(i), gap);
                        break;
                    }
                    gap++;
                }
            }
        }

        int index = 0;
        for (char i = 'a'; i <= 'z'; i++) {
            ch.put(index++, i);
        }
        System.out.println(ch);
        System.out.println(map);
        for (int i = 0; i < distance.length; i++) {
            if (distance[i] != map.getOrDefault(ch.get(i), distance[i])) {
                return false;
            }
        }

        return true;
    }
}
