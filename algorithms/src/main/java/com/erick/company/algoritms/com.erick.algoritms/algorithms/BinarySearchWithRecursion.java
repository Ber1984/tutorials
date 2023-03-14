package com.erick.company.algoritms.com.erick.algoritms.algorithms;

public class BinarySearchWithRecursion {
    public static void main(String[] args) {
        int[] array = {10, 5};
        System.out.println(binSearchRecursive(array, 6));
    }

    public static boolean binSearchRecursive(int[] array, int x, int left, int right) {
        if (left > right) {
            return false;
        }
        //int mid = (left + right) / 2;
        int mid = left + ((right - left) / 2);   /* avoiding integer overflow*/

        if (array[mid] == x) {
            return true;
        } else if (x < array[mid]) {  /*check if target value is on the left size of mid */
            return binSearchRecursive(array, x, left, mid - 1);
        } else {
            return binSearchRecursive(array, x, mid + 1, right);
        }
    }

    public static boolean binSearchRecursive(int[] array, int x) {
        return binSearchRecursive(array, x, 0, array.length - 1);
    }
}
