package com.erick.company.LeetCode.sorting;

public class MinTimeToType {
    public static void main(String[] args) {
        //System.out.println(minTimeToType("abc"));
        System.out.println(minTimeToType("bza"));
    }

    public static int minTimeToType(String word) {
        int cnt = word.length();
        char prev = 'a';
        for (int i = 0; i < word.length(); ++i) {
            char cur = word.charAt(i);
            int diff = Math.abs(cur - prev);
            cnt += Math.min(diff, 26 - diff);
            prev = cur;
        }
        return cnt;
    }

    public static int minTimeToType2(String word) {
        int right = 0, left = 0;
        if(word.length() == 1) return 1;
        for(int i = 1; i < word.length(); i++ ) {
            if( word.charAt(i - 1) > word.charAt(i) ) { //
                right += 26 - Math.abs(word.charAt(i) - word.charAt(i - 1));
            } else {
                //left
                left +=  26 - (word.charAt(i)  - word.charAt(i - 1));
            }
        }

        return right + left + 1 + word.length();
    }
}
