package com.erick.company.LeetCode.myproblems;

import java.util.HashMap;
import java.util.Map;

public class GetFirstCharacterWithOnlyOneOccurrence {

    public static void main(String[] args) {
        //Given a String of characters , return the first character with the 1 occorrence
        //Contratins = it can be some spaces in the string

        //aabboo ppmny

        System.out.println(extracted());

    }

    public static String extracted() {
        String word = "aabboo ppmny";
        Map<Character, Integer> items = new HashMap<>();
        for(char ch : word.toCharArray()) {
            if(ch != ' ') items.put(ch, items.getOrDefault(ch, 0) + 1);
        }

        //a = 2 b = 2 0 = 2 p = 2 m = 1 n = 1 y = 1
        for(Map.Entry<Character, Integer> elemenets : items.entrySet()) {
            if(elemenets.getValue() == 1) return "" + elemenets.getKey();
        }
        return "" + "not found";
    }
}
