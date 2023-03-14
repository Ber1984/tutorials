package com.erick.company.LeetCode;

public class RunTwoLoopsWithOnlyOne {
    public static void main(String[] args) {
        int[] nums = {1, 4, 6, 8};
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                break;
            }
            int num1 = nums[i];
            System.out.println("num1 " + num1);
            int j = i + 1;
            System.out.println("num2 " + nums[j]);
            sum += nums[j];
        }
        System.out.println("sum" + sum);
        String a = "ee";
        char[] array = a.toCharArray();


    }
}
