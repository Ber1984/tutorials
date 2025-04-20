package com.erick.company.LeetCode.strings;

public class MinimumMoves {

    public static void main(String[] args) {
        System.out.println(minimumMoves("XXX"));
        System.out.println(minimumMoves("XXOX"));
        System.out.println(minimumMoves("OOOO"));
    }

    public static int minimumMoves(String s) {
        int cnt = 0, zeros = 0;
        for(char ch : s.toCharArray()) {
            if(ch == 'O') {
                zeros++;
            }
        }
        if(zeros == s.length()) return 0;
        StringBuilder sbr = new StringBuilder(s);
        for(int i = 0, j = 3; i < sbr.length(); i++, j = 3 + i) {
            if(j > sbr.length()) break;
            //String selected = sbr.substring(i,j);
            for(int pos = i; pos < j; pos++) { //X
                if(sbr.charAt(pos) == 'X') {
                    sbr.replace( pos, pos + 1,"0");
                }
            }
           cnt++;
        }

        return cnt;
    }
}
