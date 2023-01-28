package LeetCode;

import java.util.HashMap;

public class ContainrsDuplicate2 {
    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1}, 3));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){

                if(Math.abs(map.get(nums[i])-i) <= k){
                    return true;
                }
                else{
                    map.put(nums[i], i);
                }
            }
            else{
                map.put(nums[i],i);
            }
        }

        return false;
    }
}
