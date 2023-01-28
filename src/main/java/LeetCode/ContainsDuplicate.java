package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{3,3}));

        /*
        HashSet num = new HashSet<>();
        for(int i=0; i<nums.length;i++){
            num.add(nums[i]);
        }
        if(num.size()!=nums.length)
            return true;
        else
            return false;

         */


}
    public static boolean containsDuplicate(int[] nums) {
        if(nums.length == 1) return false;
        Arrays.sort(nums);
        int i = 0;
        int j = 1;
        while(i < nums.length){
            if(j == nums.length) break;
            if(nums[i] == nums[j]){
                return true;
            } else {
                i++;
                j++;
            }
        }
        return false;
    }


}
