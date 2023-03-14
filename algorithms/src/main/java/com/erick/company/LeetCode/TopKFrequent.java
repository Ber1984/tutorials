package com.erick.company.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequent {
    public static void main(String[] args) {
    }
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer,Integer>  map = new HashMap<>();
            int[] top = new int[k];

            for(int i = 0;i<nums.length;i++) {
                int ele = nums[i];
                if(!map.containsKey(ele)) {map.put(ele,1);
                } else {
                    map.put(ele,map.get(ele) + 1);
                }
            }

            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
            list.sort(Map.Entry.comparingByValue());
            int i = list.size() - 1, j = 0;

            while(i >= 0){
                System.out.print(list.get(i).getValue());
                if(j < k) top[j] = list.get(i).getKey();
                i--;j++;
            }

            return top;
    }
    /*class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer,Integer>  map = new HashMap<>();
            LinkedHashMap<Integer, Integer> sortedMap = new LinkedHashMap<>();
            List<Integer> list = new ArrayList<>();
            int[] top = new int[k];

            for(int i = 0;i<nums.length;i++) {
                int ele = nums[i];
                if(!map.containsKey(ele)){
                    map.put(ele,1);
                } else {
                    map.put(ele,map.get(ele) + 1);
                }
            }

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                list.add(entry.getValue());
            }
            Collections.sort(list,Collections.reverseOrder());
            for (int num : list) {
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if (entry.getValue().equals(num)) {
                        sortedMap.put(entry.getKey(), num);
                    }
                }
            }
            System.out.println(sortedMap);
            int i = 0;
            for(Integer key:sortedMap.keySet()){
                if(i < k) top[i] = key;
                i++;
            }
            return top;
        }
    }*/
}
