package com.erick.company.LeetCode.medium;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1,2,1,-4}, 1));
    }

    public  static  int threeSumClosest(int[] nums, int target) {
        int minDiff = Integer.MAX_VALUE, result = -1;
        Arrays.sort(nums);
        for(int i = 0;i<nums.length - 2;i++){
            if(i != 0 && nums[i] == nums[i - 1]) continue;
            System.out.println("here");
            int j = i + 1, k = nums.length - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(sum - target);
                if(diff < minDiff) {
                    minDiff = diff;
                    result = sum;
                }
                if(sum < target ){
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }
}

