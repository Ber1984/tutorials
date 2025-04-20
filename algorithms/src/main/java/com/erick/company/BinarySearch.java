package com.erick.company;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1,2,3,4,6,8}, 3));
    }

    private static int binarySearch(int[] nums, int num) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int mid = (i + j) / 2;
            int middleNumber = nums[mid];
            if(middleNumber == num) return mid;
            if(num < middleNumber) j = mid - 1;
            else i = mid + 1;
        }
        return -1;
    }
}
