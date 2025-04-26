package com.erick.company.LeetCode.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumHashMap {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3,4,5,6}, 7)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i ); // 7 - 3 = 4
            // 4 = 0
            // 3 = 1
            // 2 = 2
            // 1 = 3
        }

        for(int i = 0; i < nums.length; i++) {
            int diff = target - nums[i]; //7 - 3 = 4
            if (map.containsKey(diff) && map.get(diff) != i) {
                return new int[]{i, map.get(diff)};
            }
        }

        return new int[0];
    }
}
