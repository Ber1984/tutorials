package com.erick.company.LeetCode.binarysearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSumHashMapOnlyPass(new int[]{3,3}, 6)));
    }

    private static int[] twoSum(int[] nums , int sum) {
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {
            int diff = sum - nums[i]; //2 - 2 = 0;
            int index = Arrays.binarySearch(nums, i + 1, nums.length, diff);
                if(index > 0) {
                    return new int[]{nums[i], nums[index]};
            }

        }
        return new int[]{-1, -1};
    }

    private static int[] twoSumHashMap(int[] nums , int sum) {
      Map<Integer, Integer> map = new HashMap<>();
        //3,2,4         6
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++) {
            int diff = sum - nums[i]; //6 - 2 = 4;
            if(map.containsKey(diff) && map.get(diff) != i) {
                   return new int[]{i, map.get(diff)};

            }
        }
        return new int[]{-1, -1};
    }

    private static int[] twoSumHashMapOnlyPass(int[] nums , int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        //3,2,4         6
        for(int i = 0; i < nums.length; i++) {
            int diff = sum - nums[i]; //6 - 2 = 4;
            if(map.containsKey(diff)) {
                return new int[]{i, map.get(diff)};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
