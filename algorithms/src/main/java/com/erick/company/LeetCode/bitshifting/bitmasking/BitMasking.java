package com.erick.company.LeetCode.bitshifting.bitmasking;

/*
Bit masking is a technique used to access, manipulate, or update specific bits within a binary representation of a number. It involves applying a mask (a specific bit pattern) to a number using bitwise operators.

 */
public class BitMasking {

    public static void main(String[] args) {
        /*
        Why Use Bit Masking?
To extract specific bits from a number.

To set, clear, or toggle bits.

To check the state of specific bits.

To store multiple boolean flags in a single integer.
         */

/*
Creating a Mask:

A mask is simply a binary number that has 1s in the positions we want to manipulate and 0s elsewhere.

For example, to access the 3rd bit (counting from right, starting at 0):

Mask: 00001000 (binary) = 8 (decimal).
 */

        int mask = 1 << 3; // 1 shifted left by 3 places => 8 (00001000)
        System.out.println(mask);

    /*
    1. Checking if a Bit is Set:
To check if the k-th bit is 1 or 0, use the AND operator
     */

        isBitSet(5,2);
        /*
        int num = 5; // Binary: 0101
System.out.println(isBitSet(num, 2)); // true (2nd bit is 1)
System.out.println(isBitSet(num, 1)); // false (1st bit is 0)

         */

        //2. Setting a Bit:
        //To set the k-th bit to 1, use the OR operator:
        isBitSet(5,1);

        /*
        int num = 5; // 0101
System.out.println(setBit(num, 1)); // 7 (0111)

         */


    }

    static boolean isBitSet(int num, int k) {
        int mask = 1 << k;
        return (num & mask) != 0;
    }

    int setBit(int num, int k) {
        int mask = 1 << k;
        return num | mask;
    }

    /*
    3. Clearing a Bit:
To clear (set to 0) the k-th bit, use the AND operator with the NOT operator:

int num = 5; // 0101
System.out.println(clearBit(num, 2)); // 1 (0001)

     */

    int clearBit(int num, int k) {
        int mask = ~(1 << k);
        return num & mask;
    }

/*
4. Toggling a Bit:
To toggle (flip) the k-th bit, use the XOR operator:

int num = 5; // 0101
System.out.println(toggleBit(num, 1)); // 7 (0111)
System.out.println(toggleBit(num, 1)); // 5 (0101) - Toggle again to revert

 */
    int toggleBit(int num, int k) {
        int mask = 1 << k;
        return num ^ mask;
    }

    /*
    5. Extracting Bits Using a Mask:
To extract specific bits, create a mask with 1s in the desired positions:
int num = 29;  // 11101
int mask = 0b00101; // Extract bits at positions 0 and 2
System.out.println(extractBits(num, mask)); // 5 (00101)

     */
    int extractBits(int num, int mask) {
        return num & mask;
    }

    //Real world example
    /*
    Suppose we use a single integer to store permissions, where each bit represents a specific permission:
    0001 = Read
0010 = Write
0100 = Execute
1000 = Delete

If the permission integer is 1011, it means the user has Read, Write, and Delete permissions.

     */
     //To check if the user has Write permission:
    boolean hasWritePermission(int permissions) {
        int WRITE_MASK = 0b0010;
        return (permissions & WRITE_MASK) != 0;
    }

    /*
    Binary Literals in Java:
A binary literal is a way to represent numbers in base-2 (binary) format.

The 0b or 0B prefix tells the compiler that the number that follows is in binary format.
     */
    int b = 1000; //not binary number
    int num3 = 0B1111;    // 15 in decimal (0B is also valid)
    int binaryNumber = 0b1000; //
}
