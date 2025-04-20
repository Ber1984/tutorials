package com.erick.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElement {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{1,3,5,2,4}, new int[]{6,5,4,3,2,1,7})));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        int idx = 0;
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        for (int num : nums1) { // 4
            if (map.containsKey(num)) { // 1 //0
                int pos = map.get(num);
                int[] subArray = Arrays.copyOfRange(nums2, pos + 1, nums2.length);
                int max = -1;
                for(int i = 0; i < subArray.length;i++) {
                    if(subArray[i] >  num) {
                        max = subArray[i];
                        break;
                    } else  {
                        max = -1;
                    }
                }
                ans[idx++] = max;
            }
        }
        return ans;
    }
}
