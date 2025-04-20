package com.erick.company.LeetCode.priorityqueue;

import java.util.*;

public class FinalArrayStateAfterKMultiplicationOperationsI {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getFinalState(new int[]{1,2}, 3 , 4)));
    }

    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        for(int i = 1; i <= k; i++) {
            int[] res = operation(nums, multiplier);
            nums[res[0]] = res[1];
        }
        return nums;
    }

    private static int[] operation(int[] nums, int multiplier) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] ans = new int[2];
        for(int num : nums) {
            pq.add(num); //1,2,3,5,6
        }
        List<Integer> list = new ArrayList(pq); //1,2,3,5,6
        int min = Collections.min(list);
        int count = 0;
        for(int num1 : nums) {
            if(list.contains(num1)) {
                if(num1 == min) {
                    break;
                }
                count++;
                list.remove((Integer) num1);
            }

        }
        ans[0] = count;
        ans[1] = pq.poll() * multiplier;
        return ans;
    }
}
