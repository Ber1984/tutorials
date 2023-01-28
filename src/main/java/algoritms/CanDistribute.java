package algoritms;

import java.util.*;

public class CanDistribute {
    /*
    [1,1,1,1,1]
    [2,3]

   1,2,3,4
   2
    2 = 2
    3 = 3
     */
    public static void main(String[] args) {
        System.out.println(canDistribute(new int[]{1,1,2,3}, new int[]{2,2}));
    }

    public static boolean canDistribute(int[] nums, int[] quantity) {
        //1, 1, 1, 1, 1
        List<Integer> result = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < quantity.length; i++) { //iterate twice
            for(int j = 0;j < nums.length;j++) {
                if (!st.isEmpty()) {
                    if (st.peek() == nums[j]) {
                        st.pop(); //remove the character
                        result.add(quantity[i]);
                    } else {
                        st.push(nums[j]); //add character to the stack
                    }
                } else {
                    st.push(nums[j]); //add the character
                }
            }
            //result.add(repeated);
            //repeated = 0;
        }

        for(int i = 0;i<quantity.length; i++) {
            if(!result.contains(quantity[i])) return false;
        }
        System.out.println("repeated" + result);
        return true;
    }
}
