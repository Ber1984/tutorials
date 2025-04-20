package com.erick.company;

public class WaysToSplitArray {
    public static void main(String[] args) {
        System.out.println(waysToSplitArray(new int[]{9,9,9}));
    }

    public static int waysToSplitArray(int[] nums) {
        int n = nums.length, ans = 0, sumRight = 0, sumLeft = 0,j = 0;
        long sum = 0;
        while(j < n) {
            sum+= nums[j];
            j++;
        }
        for(int i = 0; i < n - 1;i++) {
            sumLeft+= nums[i]; //-8 = 6
            sumRight = (int) (sum - sumLeft); //13 - 6 = 7
            if(sumLeft >= sumRight) {
                ans++;
            }
        }
        return ans;
    }
}
