package com.erick.company.LeetCode.greedy;

public class MinimumSteps {
    public static void main(String[] args) {
        System.out.println(minimumSteps("11000111"));
    }

    public static long minimumSteps(String s) {
        long ans = 0;
        int i = 0, j = 0;
        char[] string = s.toCharArray();
        while (i < string.length - 1) {
            if (j > string.length - 1) {
                break;
            }
            if (string[i] == '1' && string[j + 1] == '0') {
                ans++;
                char tmp = string[i]; //1
                string[i] = string[j + 1]; //0 -> tmp = 1
                string[j + 1] = tmp;
                i++;
                j = i;
            } else {
                i++;
                j = i;
            }
        }

        return ans;

    }
}
