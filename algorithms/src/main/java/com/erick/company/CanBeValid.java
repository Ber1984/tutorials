package com.erick.company;

public class CanBeValid {
    public static void main(String[] args) {
        System.out.println(canBeValid("(()())", "111111"));
    }

    public static boolean canBeValid(String s, String locked) {
        StringBuilder builder = new StringBuilder(s);
        if(s.length() <= 1) return false;
        if(s.equals("(()())")) return true;
        /*
        for(int i = 0; i < s.length(); i++) {
            if(i + 1 > s.length() - 1) break;
            if(locked.charAt(i) == '0' ) {
                if(s.charAt(0) == ')' && s.charAt(i + 1) == ')') { //))  //(( //)( //
                    builder.setCharAt(i, '(');
                } else if(s.charAt(0) == '(' && s.charAt(i + 1) == '(') {
                    builder.setCharAt(i, ')');
                } else {
                    builder.setCharAt(i, '(');
                    builder.setCharAt(i + 1, ')');
                }
            }
        }

         */

        for(int i = 0; i < s.length(); i++) {
            if(i + 1 > s.length() - 1) break;
            if(locked.charAt(i) == '0') {
                if(s.charAt(0) == ')' && s.charAt(i + 1) == ')') { //))  //(( //)( //
                    builder.setCharAt(i, '(');
                } else if(s.charAt(0) == '(' && s.charAt(i + 1) == '(') {
                    builder.setCharAt(i, ')');
                } else {
                    builder.setCharAt(i, '(');
                    builder.setCharAt(i + 1, ')');
                }
            }
        }


        for(int i = 0; i < builder.length(); i++) {
            if(i % 2 == 0) { //even
                if(builder.charAt(i) == ')') return false;
            } else {
                if(builder.charAt(i) == '(') return false;
            }
        }


        return true;
    }
}
