package com.erick.company.LeetCode.bitshifting;

public class SumTwoNums {

    public static void main(String[] args) {
        //sum two numbers using bits 3 1
        int a = 3, b = 1;
        while (b != 0 ) {
             //find carries //0 0 0 1
            int carry =  (a & b); //Calculate the carry
            a = a ^ b;  // Sum of bits where at least one of the bits is not set
            b = carry << 1 ;  // Carry is shifted left
        }
        System.out.println(a);
    }
}
