package com.erick.company.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class IntToRoman {

    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }

    public static String intToRoman(int num) {
       /* Map<Character, String> symbols = new HashMap<>();
        symbols.put('I', "1");
        symbols.put('V', "5");
        symbols.put('X', "10");
        symbols.put('L', "50");
        symbols.put('C', "100");
        symbols.put('D', "500");
        symbols.put('M', "1000");*/
        int[] values = {1, 4, 5, 9, 10, 40, 50,90, 100, 400,500, 900, 1000};
        String[] roman = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        StringBuilder sb = new StringBuilder();
        for (int i = values.length - 1; i >= 0 && num > 0; i--) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(roman[i]);
            }
        }
        return sb.toString();
    }
}
