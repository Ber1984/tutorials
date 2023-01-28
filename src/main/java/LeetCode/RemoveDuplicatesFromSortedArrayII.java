package LeetCode;

public class RemoveDuplicatesFromSortedArrayII {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,1,2,2,3}));
    }

    public static int removeDuplicates(int[] nums) {

        int i = 0,count = 0;
        for(int j = 1;j<nums.length;j++) {
            if(nums[i] == nums[j]) {
                i++;
                nums[i] = nums[j];
            } else {
                nums[i] = nums[j];
                i++;
            }
        }
        return i + 1;
    }
}
