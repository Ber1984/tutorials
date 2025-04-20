package com.erick.company;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class T {
    public static void main(String[] args) {
        int[] nums = new int[]{1,0,0,1,0,1};
        int k = 3;
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) map.put(i, nums[i]);
        }
        int count = 0;
        List<Integer> list = new ArrayList<>(map.keySet()); //0 3 5

        for(int num : list) { // 0 1 2
            if(count < k) {
                ans++;
            }
            count++;
        }
        System.out.println(ans);
    }
}
