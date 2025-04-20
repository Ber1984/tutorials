package com.erick.company;

public class AlphabetBoardPath {
    public static void main(String[] args) {
        System.out.println(alphabetBoardPath("leet"));
    }

    public static String alphabetBoardPath(String target) {
        // Where You start From
        // Current Position
        int x = 0;
        int y = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            char ch = target.charAt(i);

            int x1 = (ch - 'a') / 5;
            int y1 = (ch - 'a') % 5;
            System.out.println("x" + x1 + " " + "y" + y1);
            // if you want to move UpSide form the Current Position..
            while (x1 < x) {
                x--;
                sb.append('U');
            }
            // if you want to move Right form the Current Position..
            while (y1 > y) {
                y++;
                sb.append('R');
            }
            // if you want to move Left form the Current Position..
            while (y1 < y) {
                y--;
                sb.append('L');
            }
            // if you want to move Down form the Current Position..
            while (x1 > x) {
                x++;
                sb.append('D');
            }
            sb.append('!');
        }
        return sb.toString();
    }
}

