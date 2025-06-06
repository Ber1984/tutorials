package com.erick.company.LeetCode.bitshifting;

/*
Bitwise Operators in Java
Bitwise operators are used to perform operations on individual bits of integer data types (byte, short, int, long). These operations are faster and more memory-efficient than arithmetic operations.
 */
public class BitwiseOperation {

    public static void main(String[] args) {

    }

    void andBitwise() {
        /*
        Operation: Sets each bit to 1 if both bits are 1, otherwise 0.


        */

        int a = 5; //0101
        int b = 3; //0011
        int result = a & b;  // 0101 & 0011 = 0001 (1 in decimal)
        System.out.println(result); // Output: 1
    }

    void orBitwise() {
        /*
        Operation: Sets each bit to 1 if at least one of the bits is 1.
         */
        int a = 5;  // 0101
        int b = 3;  // 0011
        int result = a | b;  // 0101 | 0011 = 0111 (7 in decimal)
        System.out.println(result); // Output: 7

    }

    void xorBitwise() {
        /*
       Sets each bit to 1 if the corresponding bits are different.
         */
        int a = 5;  // 0101
        int b = 3;  // 0011
        int result = a ^ b;  // 0101 ^ 0011 = 0110 (6 in decimal)
        System.out.println(result); // Output: 6


    }

    void notBitwise() {
        /*
        Operation: Inverts all bits (0 becomes 1 and 1 becomes 0).

In Java, the ~ operator flips all bits and also inverts the sign of the number (because of two's complement representation).
         */

        int a = 5;    // 00000000 00000000 00000000 00000101
        int result = ~a; // 11111111 11111111 11111111 11111010 (-6 in decimal)
        System.out.println(result); // Output: -6

    }

    void leftShiftBitwise() {
        /*
     Operation: Shifts bits to the left and fills the rightmost bits with 0.

Each left shift by n bits is equivalent to multiplying by 2^n.
         */

        int a = 5;  // 00000000 00000000 00000000 00000101
        int result = a << 2; // 00000000 00000000 00000000 00010100 (20 in decimal)
        System.out.println(result); // Output: 20

    }

    void rightShiftBitwise() {
        /*
        Operation: Shifts bits to the right and fills the leftmost bits with the sign bit (0 for positive, 1 for negative).

Each right shift by n bits is equivalent to dividing by 2^n.
         */

        int a = 20; // 00000000 00000000 00000000 00010100
        int result = a >> 2; // 00000000 00000000 00000000 00000101 (5 in decimal)
        System.out.println(result); // Output: 5

    }
}
