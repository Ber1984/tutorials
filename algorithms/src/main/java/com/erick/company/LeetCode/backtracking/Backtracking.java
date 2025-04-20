package com.erick.company.LeetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Backtracking {

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums);
        return res;
    }

    private static void backtrack(List<List<Integer>> resulList,
                           ArrayList<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) { //goal is reach
            resulList.add(new ArrayList<>(tempList));
            return;
        }
        for (int number : nums) {
            if (tempList.contains(number)) continue;
            tempList.add(number);

            backtrack(resulList, tempList, nums);
            tempList.remove(tempList.size() - 1);
        }
    }
}
