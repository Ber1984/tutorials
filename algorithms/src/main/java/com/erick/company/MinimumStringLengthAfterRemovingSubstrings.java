package com.erick.company;

public class MinimumStringLengthAfterRemovingSubstrings {
    public static void main(String[] args) {
        System.out.println(minLength("ABFCACDB"));
    }

    public static int minLength(String s) {
        StringBuilder sbr = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            sbr.append(currentChar);

            int length = sbr.length();
            // Check if we can reduce the current StringBuilder
            if (length >= 2) {
                // Remove "AB" or "CD" if they appear at the end
                if ((sbr.charAt(length - 2) == 'A' && sbr.charAt(length - 1) == 'B') ||
                        (sbr.charAt(length - 2) == 'C' && sbr.charAt(length - 1) == 'D')) {
                    sbr.delete(length - 2, length); // Remove the last two characters
                }
            }
        }

        return sbr.length();



    }
}
