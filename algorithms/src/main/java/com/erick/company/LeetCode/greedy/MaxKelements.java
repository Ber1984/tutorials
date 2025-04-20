package com.erick.company.LeetCode.greedy;

public class MaxKelements {

    public static void main(String[] args) {
        System.out.println(maxKelements(new int[]{10,10,10,10,10}, 5));
    }

    public static long maxKelements(int[] nums, int k) {
        //in place
        long ans = 0, start = 0, end = nums.length - 1, score = 0, count = 0;

        for(int i = 0; i < nums.length; i++) {
            if(count > k) break;
            if(i >= 0 && i < nums.length) {
                ans += nums[i];
                nums[i] = (int) Math.ceil(nums[i] / 3);
                count++;
            }
        }
    return ans;
    }
}
