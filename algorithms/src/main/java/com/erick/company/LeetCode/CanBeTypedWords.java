package com.erick.company.LeetCode;

public class CanBeTypedWords {

    public static void main(String[] args) {
        System.out.println(canBeTypedWords("leet code", "lt"));
        System.out.println(canBeTypedWords("hello world", "ad"));
        System.out.println(canBeTypedWords("leet code", "e"));
    }

    public static int canBeTypedWords(String text, String brokenLetters) {
        int ans = 0, brokenCurrentlength = brokenLetters.length(); //2
        String[] words = text.split(" "); // hello, world



            for (String word : words) {

                for (char ch : brokenLetters.toCharArray()) {

                //hello
                if (word.contains(String.valueOf(ch))) {
                    brokenCurrentlength--;
                }
            }

            System.out.println("brokenCurrentlength " + brokenCurrentlength + " " +brokenLetters.length());
            if (brokenLetters.length() == brokenCurrentlength) {
                ans++;
                System.out.print("enter");
            }
            brokenCurrentlength = brokenLetters.length();

        }
        return  ans;
    }
}
