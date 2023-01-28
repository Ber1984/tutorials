package algoritms;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseAllVowel {

    public static void main(String[] args) {
        //reverseVowels("hello"); //holle
        reverseVowels("leetcode"); //leotcede
    }

    public static String reverseVowels(String s) {
        //two pointers
        char[] srtArray = s.toCharArray();
        int start = 0, end = s.length() - 1;

        // While we still have characters to traverse
        while (start < end) {
            // Find the leftmost vowel
            while (start < s.length() && !isVowel(srtArray[start])) {
                start++;
            }
            // Find the rightmost vowel
            while (end >= 0 && !isVowel(srtArray[end])) {
                end--;
            }
            // Swap them if start is left of end
            if (start < end) {
                swap(srtArray, start++, end--);
            }
        }
        // Converting char array back to String
        return new String(srtArray);
    }

    // Function to swap characters at index x and y
    static void swap ( char[] chars, int x, int y){
        char temp = chars[x];
        chars[x] = chars[y];
        chars[y] = temp;
    }

    // Return true if the character is a vowel (case-insensitive)
    static boolean isVowel(char c) {
        return c == 'a' || c == 'i' || c == 'e' || c == 'o' || c == 'u'
                || c == 'A' || c == 'I' || c == 'E' || c == 'O' || c == 'U';
    }
}
