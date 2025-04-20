package com.erick.company.LeetCode.strings;

public class Test {
    public static void main(String[] args) {
        System.out.println(countValidWords("cat and  dog"));
        System.out.println(countValidWords("!this  1-s b8d!"));
        System.out.println(countValidWords("alice and  bob are playing stone-game10"));
        System.out.println(countValidWords("stone-game10"));
        System.out.println(countValidWords("-"));
    }

    public static int countValidWords(String sentence) {
        String[] noSpaces = sentence.split(" "); // cat,and,dog
        int ans = 0;
        for (String word : noSpaces) {
            if (!word.isEmpty() && isOnlyLetter(word) && isAtMostHyphen(word) && isOnlyPuntuaction(word)) {
                ans++;
            }
        }

        return ans;
    }

    private static boolean isOnlyLetter(String str) {
        for (char ch : str.toCharArray()) {
            if (Character.isDigit(ch))
                return false;
        }
        return true;
    }

    private static boolean isAtMostHyphen(String str) {
        int i = 0, j = 0;
        boolean isHyphen = true, ans = true;
        while(i < str.length()) {
            if(isHyphen  && str.charAt(i) == '-' && i + 1 < str.length() && Character.isLetter(str.charAt(i - 1)) && Character.isLetter(str.charAt(i + 1))) {
               isHyphen = false;
            } else {
                ans = false;
            }
            i++;
        }
        return ans;
    }

    private static boolean isOnlyPuntuaction(String str) {
        int i = 0, j = 0;
        int  isPuntuaction = 0;
        boolean ans = true;
        while(i < str.length()) {
            if(str.charAt(i) == '!') {
                isPuntuaction++; //1
            }
            i++;
        }

        if(isPuntuaction >= 1 && !str.endsWith("!")) {
            ans = false;
        }
        return ans;
    }
}
