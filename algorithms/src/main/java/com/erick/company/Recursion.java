package com.erick.company;

public class Recursion {
    static String palindrome = "rotatom";
    static int  start = 0, end = palindrome.length() - 1;
    static int i = 0;
    static int n = 100;
    public static void main(String[] args) {
        System.out.println("is anagram" + getPalindrome());
        //printNumbers(0);
    }

    public static boolean getPalindrome() {
        if(helper(start, end, palindrome)) return helper(start++, end--, palindrome);
        return false;
    }

    public static boolean helper(int start, int end, String str) {
        return str.charAt(start) == str.charAt(end);
    }
    public static void printNumbers(int number) {
        // Base case: Stop the recursion when the number is greater than 100
        if (number > 100) {
            return;
        }

        // Print the current number
        System.out.println(number);

        // Recursive call to print the next number
        printNumbers(number + 1);
    }
}
