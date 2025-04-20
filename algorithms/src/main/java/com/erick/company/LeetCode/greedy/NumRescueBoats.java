package com.erick.company.LeetCode.greedy;

import java.util.Arrays;

public class NumRescueBoats {


    public static void main(String[] args) {
        System.out.println(numRescueBoats(new int[]{1,2}, 3));
    }
    public static int numRescueBoats(int[] people, int limit) {
        // 3 2 2 1 => 1 2 2 3
        int ans = 0, start = 0, end = 1, remaining = 0, sum = 0;
        Arrays.sort(people);

        while(start < people.length) {
            if(end > people.length) break;
            if(people[start] == limit) {
                ans++;
                start++;
                end++;
                continue;
            }


            for(int peo : Arrays.copyOfRange(people, start, end + 1)) {
                sum += peo;
            }
            if(sum > limit) {
                ans++;
                start++;
                end++;
            }
            if(sum == limit) {
                ans++;
                start = end + 1;
                end = start + 1;
            }

            sum = 0;

        }

        return ans;
    }
}
