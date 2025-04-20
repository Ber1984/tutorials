package com.erick.company.LeetCode.bitshifting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class XorAllNums {
    public static void main(String[] args) {
        System.out.println(xorAllNumsBruceForce(new int[]{1,2}, new int[]{3,4}));
        System.out.println(xorAllNumsOptimalSolution(new int[]{1,2}, new int[]{3,4}));
    }

    public static int xorAllNumsBruceForce(int[] nums1, int[] nums2) {
        //0 - 13
        //1 - 14
        //2 - 23
        //3 - 24
        int[] pairs = new int[nums1.length * nums2.length];
        int ans = 0;
        int count = 0;
        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {
                pairs[count++] =  nums1[i] ^ nums2[j];
            }
        }

        for(int num : pairs) {
            ans ^= num;
        }

        return ans;
    }

    public static int xorAllNumsOptimalSolution(int[] nums1, int[] nums2) {
        //0 - 13
        //1 - 14
        //2 - 23
        //3 - 24
        int[] pairs = new int[nums1.length * nums2.length];

        Map<String, Integer> map = new HashMap<>();
        int ans = 0;
        int count = 0;
        for (int k = 0; k < nums1.length * nums2.length; k++) {
            int i = k / nums2.length; // Index for list1
            int j = k % nums2.length; // Index for list2
            String key = "(" + nums1[i] + ", " +nums2[j] + ")";
            int product = nums1[i] ^ nums2[j];
            map.put(key, product);
        }


        for(int num : map.values()) {
            ans ^= num;
        }

        return ans;
    }
}
