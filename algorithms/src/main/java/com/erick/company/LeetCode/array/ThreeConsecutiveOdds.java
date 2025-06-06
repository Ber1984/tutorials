package com.erick.company.LeetCode.array;

public class ThreeConsecutiveOdds {

    public static void main(String[] args) {
        System.out.println(threeConsecutiveOdds(new int[]{1,2,34,3,4,5,7,23,12}));
    }

    public static boolean threeConsecutiveOdds(int[] arr) {
        if (arr.length < 3) return false;

        for (int i = 0; i <= arr.length - 3; i++) {
            if (isOdd(arr[i]) && isOdd(arr[i + 1]) && isOdd(arr[i + 2])) {
                return true;
            }
        }
        return false;
    }

    private static boolean isOdd(int num) {
        return num % 2 != 0;
    }
}
