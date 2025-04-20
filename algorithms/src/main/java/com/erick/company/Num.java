package com.erick.company;

public class Num {

    public static void main(String[] args) {
        numSub("0110111");
    }

    public static int numSub(String s) {
        int count = 0;
        int consecutiveOnes = 0;
        int mod = 1_000_000_007; // To handle large counts and avoid overflow

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                consecutiveOnes++;
                count = (count + consecutiveOnes) % mod;
            } else {
                consecutiveOnes = 0;
            }
        }

        return count;
    }
}
