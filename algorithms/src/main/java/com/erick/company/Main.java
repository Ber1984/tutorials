package com.erick.company;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println(minimumLength2("ca"));

    }
    public static int minimumLength2(String s) {
        StringBuilder sbr = new StringBuilder(s);
        int i = 0, j = sbr.length() - 1;
        while (i < j) {
            String prefix = "";
            String suffix = "";
            System.out.println("i" + i + "j" + j);
            if(sbr.toString().isEmpty()) break;
            if (sbr.charAt(i) != ' ' && sbr.charAt(j) != ' ') { // empty base case
                if (sbr.charAt(i) == sbr.charAt(j)) {

                    int prefixIndex = 0; // a
                    while (prefixIndex < sbr.length()) { // c
                        if (sbr.charAt(i) == sbr.charAt(prefixIndex)) { // c == c
                            prefix += sbr.charAt(i);
                        } else {
                            break;
                        }
                        prefixIndex++;
                    }
                    System.out.println("pre " + prefix);
                    int suffixIndex = sbr.length() - 1; // a
                    while (suffixIndex >= 0) {
                        System.out.print("suffix index " + suffixIndex);
                        if (sbr.charAt(j) == sbr.charAt(suffixIndex)) { // b
                            suffix += sbr.charAt(j);
                        } else {
                            break;
                        }
                        suffixIndex--;
                    }
                    System.out.println("suf " + suffix);
                    // C C The characters from the prefix and suffix must be the same.

                    if(!sbr.toString().isEmpty()) {
                        if(!prefix.isEmpty()) {
                            for(char ch : prefix.toCharArray()) {
                                sbr.deleteCharAt(0);
                            }
                        }


                        if(!sbr.toString().isEmpty()) {
                            for(char ch : suffix.toCharArray()) {
                                sbr.deleteCharAt(sbr.length() - 1);
                            }
                        }
                    }

                    System.out.println("str " + sbr);
                    i = 0;
                    j = sbr.length() - 1;
                } else {
                    i++;
                    j--;
                }

            }
        }
        return sbr.toString().length();
    }
    public static int minimumLength(String s) {
        StringBuilder sbr = new StringBuilder(s);
        int i = 0, j = sbr.length() - 1; // c. c
        ArrayList<Integer> prefix = new ArrayList();
        ArrayList<Integer> suffix = new ArrayList();
        while (i < sbr.length()) {
            System.out.println("i" + i + "j" + j);
            if (sbr.charAt(i) != ' ' && sbr.charAt(j) != ' ') { // empty base case
                if (sbr.charAt(i) == sbr.charAt(j)) {
                    int prefixIndex = 0; // a
                    while (prefixIndex < sbr.length()) { // c
                        if (sbr.charAt(i) == sbr.charAt(prefixIndex)) { // c == c
                            prefix.add(i);
                        } else {
                            break;
                        }
                        prefixIndex++;
                    }
                    System.out.println("pre " + prefix);
                    int suffixIndex = sbr.length() - 1; // a
                    while (suffixIndex >= 0) {
                        System.out.print("suffix index " + suffixIndex + "j" + j);
                        if (sbr.charAt(j) == sbr.charAt(suffixIndex)) { // b
                            suffix.add(j);
                        } else {
                            break;
                        }
                        suffixIndex--;
                    }
                    System.out.println("suf " + suffix);
                    // C C The characters from the prefix and suffix must be the same.

                    for (int num : prefix) {
                        sbr.deleteCharAt(num);
                    }

                    // Delete both the prefix and the
                    for (int num : suffix) {
                        sbr.deleteCharAt(num);
                    }

                    System.out.println("str " + sbr);
                    i = 0;
                    j = sbr.length() - 1;
                } else {
                    i++;
                    j--;
                }

            }
        }
        return sbr.toString().length();
    }
}