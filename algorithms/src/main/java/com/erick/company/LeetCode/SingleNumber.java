package com.erick.company.LeetCode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{'2', '2', '1'}));

    }

    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> aux = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if (aux.containsKey(key)) aux.put(key, (aux.get(key) + 1));
            else aux.put(key, 1);
        }
        return aux.entrySet()
                .stream()
                .min(Comparator.comparing(Map.Entry::getValue))
                .get()
                .getKey()
                .intValue();
    }
}
