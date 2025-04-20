package com.erick.company;

public class RemoveDuplicates {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,1,2,2,3}));
    }

    public static int removeDuplicates(int[] nums) {
        //[1,1,1,2,2,3] //[1,1,2,2,3,_]
        int count = 1; //3
        int currentNumber = nums[0];
        int i = 1;
        int ans = 0;
        int pos = 0;
        int deleted = 0;
        while(i < nums.length) {
            if(nums[i] == currentNumber && count <= 2) {
                count++;
                if(count > 2) {
                    pos = i; //2
                }
                i++;
            } else {
                currentNumber = nums[i]; //2
                nums[pos] = currentNumber;
                deleted++;
                ans += count;
                count = 1;
            }

        }
        return nums.length - deleted;

    }
}
