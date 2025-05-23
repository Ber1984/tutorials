package com.erick.company;

import java.util.Arrays;

public class SmallestChair {
    public static void main(String[] args) {
        System.out.println(smallestChair(new int[][]{{1,4},{2,3},{4,6}}, 1));
    }

    public static int smallestChair(int[][] times, int targetFriend) {
        int[] targetTime = times[targetFriend];
        Arrays.sort(times, (a, b) -> Integer.compare(a[0], b[0]));

        int n = times.length;
        int[] chairTime = new int[n];

        for (int[] time : times) {
            for (int i = 0; i < n; i++) {
                if (chairTime[i] <= time[0]) {
                    chairTime[i] = time[1];
                    if (Arrays.equals(time, targetTime)) return i;
                    break;
                }
            }
        }
        return 0;
    }
}
