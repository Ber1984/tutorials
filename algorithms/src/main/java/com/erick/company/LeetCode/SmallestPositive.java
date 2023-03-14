package com.erick.company.LeetCode;

import java.util.Arrays;

public class SmallestPositive {
    public static void main(String[] args) {
        System.out.println(smallestPositive(new int[]{-1,-3}));
    }

    private static int smallestPositive(int[] A) {
        int smallest = 0;
        Arrays.sort(A);
        int count = 1;
        for (int i = 0; i < A.length; i++) {
            if (count == A[i]) {
                count++;
            } else {
                smallest = count;
            }
        }
        return count;
    }
}
