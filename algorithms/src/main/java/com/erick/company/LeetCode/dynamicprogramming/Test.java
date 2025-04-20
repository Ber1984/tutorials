package com.erick.company.LeetCode.dynamicprogramming;

public class Test {
    static StringBuilder sbr;
    public static void main(String[] args) {
        System.out.println(minExtraChar("sayhelloworldoo", new String[]{"hello","world"
}));
    }

    public static int minExtraChar(String s, String[] dictionary) {
        int ans = 0;
        sbr = new StringBuilder(s);

        for (String word : dictionary) {
            helper(sbr, word);
        }

        return sbr.toString().length();

    }

    private static void helper(StringBuilder s , String word) {

        if(s.toString().contains(word)) {
            sbr = new StringBuilder(sbr.toString().replaceAll(word, ""));
        }
    }
}
