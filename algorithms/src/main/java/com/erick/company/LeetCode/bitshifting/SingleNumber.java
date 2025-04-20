package com.erick.company.LeetCode.bitshifting;

public class SingleNumber {
    public static void main(String[] args) {
        int a = 5;   // Binary: 101
        int b = 3;   // Binary: 011

        if ((a & b) == b) {
            System.out.println("All bits in 'b' are set in 'a'");
        }

    }
    }

