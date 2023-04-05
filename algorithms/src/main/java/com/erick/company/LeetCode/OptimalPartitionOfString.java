package com.erick.company.LeetCode;

import java.util.ArrayList;

public class OptimalPartitionOfString {
    public static void main(String[] args) {
        partitionString("ssssss");
    }

    public static int partitionString(String s) {
        ArrayList<String> stb = new ArrayList<>();
        String aux = "";
        //char[] array =  s.toCharArray();
        int i = 1,  j = i + 1;
        int index = 2;
        stb.add(String.valueOf(s.charAt(0)));
        while(i < s.length() ) {
            if(j > s.length()) {
                stb.add(String.valueOf(s.charAt(s.length() - 1)));
                break;
            }
            //System.out.println("i" + i);
            //System.out.println("j" + j);
            String sbt = s.substring(i,j + 1);

            if(isDifferent(sbt)) {
                System.out.println("here in is ");
                //aux += String.valueOf(array[i]) + String.valueOf(array[j]);
                stb.add(sbt);
                i = j + 1;
                index += i;
                j = index;
            } else {

                i += 2;
                j += 2;
            }
            sbt = "";
        }
        System.out.println(stb);
        return 1;
    }

    private static boolean isDifferent(String substring) {
        for(int k = 0;k<substring.length();k++) {
            for(int p = k + 1;p<substring.length();p++) {
                if(substring.charAt(k) == substring.charAt(p)) {
                    return false;
                }
            }

        }
        return true;
    }
}
