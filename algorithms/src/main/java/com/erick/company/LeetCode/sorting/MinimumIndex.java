package com.erick.company.LeetCode.sorting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndex {

    public static void main(String[] args) {
        System.out.println(minimumIndex(List.of(1,2,2,2)));
    }
    public static int minimumIndex(List<Integer> nums) {
        Map<Integer, Integer> firstMap = new HashMap<>();
        Map<Integer, Integer> secondMap = new HashMap<>();
        int n = nums.size();

        // Add all elements of nums to secondMap
        for (int num : nums) {
            secondMap.put(num, secondMap.getOrDefault(num, 0) + 1);
        }

        for (int index = 0; index < n; index++) {
            // Create split at current index
            int num = nums.get(index);
            secondMap.put(num, secondMap.get(num) - 1);
            firstMap.put(num, firstMap.getOrDefault(num, 0) + 1);

            // Check if valid split
            if (
                    firstMap.get(num) * 2 > index + 1 &&
                            secondMap.get(num) * 2 > n - index - 1
            ) {
                return index;
            }
        }

        // No valid split exists
        return -1;
    }
}
