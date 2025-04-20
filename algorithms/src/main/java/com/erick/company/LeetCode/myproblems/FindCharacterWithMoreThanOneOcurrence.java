package com.erick.company.LeetCode.myproblems;

import java.util.Arrays;

public class FindCharacterWithMoreThanOneOcurrence {
    public static void main(String[] args) {
        System.out.println(result("abbbbbop", 'p'));

    }

    private static String result(String input , char target) {
        //count the occurences
        //find the chacater and validate if it has more than 1 occu
        //return

        int[] counts = new int[26];

        for(char ch : input.toCharArray()) {
            counts[ch - 'a']++; //get the position in the alphabet
        }

        System.out.println(Arrays.toString(counts));
        //1 0 1 0 2
            if(counts[target - 'a'] > 1) { //get the positio of this charcater and see if greater
                return "" + target;
            }

        return "Not found";
    }
}
