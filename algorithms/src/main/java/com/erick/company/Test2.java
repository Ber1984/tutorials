package com.erick.company;

public class Test2 {

    public static void main(String[] args) {
        String s = "0110101";
        //s = s.replaceAll("01", "10");

        int ans = 0;

        while(s.contains("01")) {
            ans++;
            s = s.replaceAll("01", "10");
        }
    }
}
