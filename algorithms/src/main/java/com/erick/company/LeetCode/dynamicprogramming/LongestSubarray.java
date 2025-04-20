package com.erick.company.LeetCode.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarray {

    public static void main(String[] args) {
        longestSubarray(new int[]{0,1,1,1,0,1,1,0,1});
    }

    public static int longestSubarray(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        int rightZero, leftZero = 0, i = 1;
        int pos = 0;
        int zeros = 0;
        while(i < nums.length - 1) {
            if(nums[i] == 1) {
                leftZero++; //3
            }
            if(nums[i] == 0 && nums[i - 1] == 1 && nums[i + 1] == 1) {
                zeros++;

            }
            if(zeros == 1) {
                map.put(pos++, leftZero);
                zeros = 0;
            }
            i++;
        }
        System.out.print(map);

        return 0;


    }
}
