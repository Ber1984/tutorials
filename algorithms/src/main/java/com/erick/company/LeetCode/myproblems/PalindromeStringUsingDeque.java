package com.erick.company.LeetCode.myproblems;

import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeStringUsingDeque {

    public static void main(String[] args) {
        System.out.println(isPalindrome("aabaa"));
        System.out.println(isPalindrome("aabaatt"));
    }

    private static boolean isPalindrome(String word) {
        Deque<Character> deque = new ArrayDeque<>();

        for(char ch : word.toCharArray()) {
            deque.add(ch); //Deque construction (for loop): O(n) — where n is the length of the input string.
        }

        while (deque.size() > 1){
            if(deque.peekFirst().charValue() != deque.peekLast().charValue()) return false; //Palindrome check (while loop): O(n/2) = O(n)
            deque.removeFirst();
            deque.removeLast();
        }

        //Each operation (peekFirst, peekLast, removeFirst, removeLast) is O(1) in ArrayDeque.
        /*
        🔹 Overall Time Complexity: O(n)
        🔹 Space Complexity: O(n) — for storing all characters in the Deque.
         */

        return true;
    }
}
