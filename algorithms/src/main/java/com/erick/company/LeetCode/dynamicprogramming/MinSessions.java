package com.erick.company.LeetCode.dynamicprogramming;

public class MinSessions {
    public static void main(String[] args) {
        System.out.println(minSessions(new int[]{1,7}, 7));
        //System.out.println(minSessions(new int[]{3,1,3,1,1}, 8));

    }

    public static int minSessions(int[] tasks, int sessionTime) {
        int ans = 0;

        int[] dp = new int[tasks.length + 1];
        int j = 0;
        for(int i = 0; i < tasks.length; i++) {
            if(tasks[i] < sessionTime || j > 0 && tasks[j - 1] < sessionTime) {
                if( j > 0 && dp[j - 1] + tasks[i] == sessionTime) {
                    ans++;
                    dp[j - 1] = 0;
                    continue;
                } else if(j > 0 && dp[j - 1] + tasks[i] > sessionTime) {
                    ans++;
                    dp[j - 1] = 0;
                }
                if(j > 0)  dp[i] = dp[j - 1] + tasks[i];
                if(j == 0 ||  (j > 0  )) {
                    dp[i] = tasks[i];
                    if(j < tasks.length - 1 && dp[j - 1] + tasks[j + 1] > sessionTime) {
                        ans++;
                    }
                }
            } else  if(tasks[i] == sessionTime || i == tasks.length - 1 ) {
                dp[i] = tasks[i];
                ans++;
            }
            j++;
        }
        return ans;
    }

    public static int minSessions1(int[] tasks, int sessionTime) {
        int ans = 0;

        int[] dp = new int[tasks.length + 1];
        int j = 0;
        for(int i = 0; i < tasks.length; i++) {
            if(tasks[i] == sessionTime || i == tasks.length - 1) {
                dp[i] = tasks[i];
                ans++;
            } else if(tasks[i] < sessionTime ) {
                if( j > 0 && dp[j - 1] + tasks[i] == sessionTime) {
                    ans++;
                    dp[j - 1] = 0;
                    continue;
                }
                if(j > 0)  dp[i] = dp[j - 1] + tasks[i];
                if(j == 0) dp[i] = tasks[i];
            }
            j++;
        }
        return ans;
    }
}
