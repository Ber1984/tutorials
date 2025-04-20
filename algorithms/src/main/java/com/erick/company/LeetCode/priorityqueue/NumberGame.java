package com.erick.company.LeetCode.priorityqueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class NumberGame {
    public static void main(String[] args) {
        System.out.println(numberGame(new int[]{2, 3, 4, 5}));
    }

    public static int[] numberGame(int[] nums) {
        int[] ans = new int[nums.length];
        PriorityQueue<Integer> min_heap = new PriorityQueue();

        for(int num : nums) min_heap.add(num);
        System.out.println(min_heap);
        int alice = 1, bob = 0;
        while(!min_heap.isEmpty()) {
            ans[alice] = min_heap.poll(); //2
            ans[bob] = min_heap.poll(); //3
            alice += 2; bob  += 2;
        }
        System.out.println(Arrays.toString(ans));
        return null;
    }
}
