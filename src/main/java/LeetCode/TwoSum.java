package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        System.out.println(twoSum());
    }

    public static int[] twoSum() {
        int target = 6;
        int[] nums = {1, 4, 5};
        Map<Integer, Integer> num_map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (num_map.containsKey(complement)) {
                return new int[]{num_map.get(complement), i};
            }
            num_map.put(nums[i], i);
        }
        throw new IllegalArgumentException("no match found");
    }
}
