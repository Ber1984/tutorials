package com.erick.company.LeetCode.bitshifting;

public class MinChange {
    public static void main(String[] args) {
        System.out.println(minChanges(13, 4));
    }

    public static int minChanges(int n, int k) {
        int c = 0;
        for (int i = 0; i < 31; i++) { //Loop through the bits (assuming 31-bit integers).
            int bit_mask = (1 << i); // (1) (1 0) (1 0 0).... Creates a bit mask with only the i-th bit set to 1.

            int b1 = n & bit_mask; // Get the i-th bit of n.
            int b2 = k & bit_mask; // Get the i-th bit of k.

            if (b2 == 0 && b1 != 0) {
                n ^= bit_mask; // flip
                c++;
            }
        }

        return (n == k ? c : -1);
    }
}
