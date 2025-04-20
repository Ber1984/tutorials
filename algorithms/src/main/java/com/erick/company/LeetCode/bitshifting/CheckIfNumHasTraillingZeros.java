package com.erick.company.LeetCode.bitshifting;

public class CheckIfNumHasTraillingZeros {

    public static void main(String[] args) {
        System.out.println(extracted());

    }

    private static boolean extracted() {
        //int[] nums = {1,2,3,4,5};
        int[] nums = {1,2,3,4,5};
        //int[] nums = {1,2,3,4,5};
        int count = 0, i = 0, j = 1;
        while(i < nums.length - 1 ) { //1
            if(j == nums.length) {
                i++;
                j = i + 1;
            }
            if(j == nums.length && i == nums.length - 1) {
                break;
            }
            if((((nums[i] | nums[j]) & 1) == 0)) {
                return true;
            } else {
                j++;
            }
        }
        return false;
    }
}
