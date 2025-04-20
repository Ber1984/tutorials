package com.erick.company.LeetCode.priorityqueue;

import java.util.*;

public class MaxSubsequence {
    public static void main(String[] args) {
        System.out.println(maxSubsequence(new int[]{-1,-2,3,4}, 3));
    }

    public static int[] maxSubsequence(int[] nums, int k) {
        // Create a priority queue to store the k largest elements
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Traverse the nums array and store the largest k elements in the priority queue
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll(); // Remove the smallest element if the size exceeds k
            }
        }

        // Now pq contains the k largest elements, we will use a list to preserve their order from original nums
        List<Integer> largestK = new ArrayList<>(pq);

        int[] ans = new int[k];
        int index = 0;

        // Traverse the original nums array and pick the k largest in order
        for (int num : nums) {
            if (largestK.contains(num)) {
                ans[index++] = num;
                largestK.remove((Integer) num); // Remove the element from the list to avoid duplicates
                if (index == k) break;
            }
        }
        System.out.println(Arrays.toString(ans));
        return ans;


    }
}
