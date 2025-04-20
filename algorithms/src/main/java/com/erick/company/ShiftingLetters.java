package com.erick.company;

import java.util.HashMap;

public class ShiftingLetters {
    public static void main(String[] args) {
        System.out.println(shiftingLetters("dztz", new int[][]{{0,0,0},{1, 1,1}}));
    }

    public static String shiftingLetters(String s, int[][] shifts) {
        //abc = zac // zbd // ace
        HashMap<Integer, Character> map = new HashMap<>();

        for(int index = 0; index < shifts.length; index++) map.put(index, s.charAt(index));
        StringBuilder builder = new StringBuilder(s);
        for(int[] shift : shifts) { //0,1,0]
            int start = shift[0];  //0
            int end = shift[1];  //1
            int direction = shift[2]; //0

            if(direction == 0) {
                while (start <= end) {
                    int newCharPosition = (builder.charAt(start) - 'a'  - 1 + 26) % 26;
                    builder.setCharAt(start, (char) ('a' + newCharPosition)); //backward
                    start++;
                }

            } else {
                while (start <= end) {
                    int newCharPosition = (builder.charAt(start) - 'a'  + 1 + 26) % 26;
                    builder.setCharAt(start, (char) ('a' + newCharPosition)); //backward
                    start++;
                }
            }

        }

        return builder.toString();

    }
}
