package com.erick.company.LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class ZeroArrayTransformationI {

    public static void main(String[] args) {
        //System.out.println(isZeroArray(new int[]{1,0,1}, new int[][]{{0, 2}}));
        System.out.println(isZeroArray1(new int[]{4,3,2,1}, new int[][]{{1, 3}, {0,2}}));
    }

    public static boolean isZeroArray(int[] nums, int[][] queries) {
        for(int[] query : queries) { //
            //get the range
            for(int i = query[0] ; i <= query[1]; i++) { //1 3
                if(nums[i] != 0) --nums[i];
            }
        }

        int sum = Arrays.stream(nums).sum();
        System.out.print("sum" + sum);

        return sum == 0;
    }

    public static boolean isZeroArray1(int[] nums, int[][] queries) {
        HashMap<Integer, Integer> map = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
        }

        for (int[] query : queries) { //O(n)
            //get the range
            // 0 2

            for (int i = query[0]; i <= query[1]; i++) { //1 3
                if (map.containsKey(i) && map.get(i) != 0) {
                    map.put(i, map.get(i) - 1);
                }
            }
        }

        int sum = map.values().stream().reduce(0, Integer::sum);;
        return sum == 0;
    }


}
