package com.erick.company.LeetCode.myproblems;

import java.util.Collections;
import java.util.HashMap;

public class ReturnMaxStringWithMoreOccurrence {
    public static void main(String[] args) {
        /*
        Challenge:
        Given a string containing multiple words separated by spaces, find and return the word that contains a character with the highest frequency among all the words.

        Example Input:
        "aabbjjjj gtygts uuuuuuupoooo"

        Output:
        "uuuuuupoooo"
         */

        /*
        Explanation:
        "aabbjjjj" → max char freq = 4 (for 'j')
        "gtygts" → max char freq = 2
        "uuuuuupoooo" → max char freq = 7 (for 'u') → This is the highest
         */
        System.out.println(maxValue("aabbjjjj gtygts uuuuuuupoooo"));
    }

    private static String maxValue(String word) {
        /*
        n = total number of characters in the input string
        k = average length of each word
        m = number of words (so n ≈ m * k)
         */



        int max = Integer.MIN_VALUE;
        String ans = "";
        String[] words = word.split(" "); //[aabbjjjj, gtygts, uuuuuuupoooo] //O(n)
        var count = new HashMap<Character, Integer>();
        for(String str : words) { //O(m)
            //count
            count.clear();
            for(char ch : str.toCharArray()) count.put(ch, count.getOrDefault(ch, 0) + 1); //O(k)
            int maxValue = Collections.max(count.values()); //4 O(26) → since max size of count = number of unique characters (bounded, max 26 for lowercase letters, 128 for ASCII) ⇒ O(1)
            //is O(number of values), which in this case is bounded and small ⇒ O(1).

            if(maxValue > max) {
                ans = str;
                max = maxValue;
            }
        }
        return ans;

        //Space complexity O(1)
        //Time complexity O(n) due to the hash collision in put methods I'm not sure what time complexity of Collections.max is

        /*
        For each word, you create a frequency Map<Character, Integer>:

        Max 128 ASCII characters → O(1) space per word
        You don’t store them all at once, just one at a time.
        Space Complexity: O(1) (constant extra space, ignoring input size)
         */
    }
}
