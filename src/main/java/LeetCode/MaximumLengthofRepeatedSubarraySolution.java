package LeetCode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaximumLengthofRepeatedSubarraySolution {
    public static void main(String[] args) {
        int[] nums1 = {0, 0, 0, 0, 1};
        int[] nums2 = {1, 0, 0, 0, 0};
        int maximun = 0;
        int[] tmp = new int[nums1.length];
        for (int j = 0; j < nums1.length; j++) {
            int num1 = nums1[j];
            System.out.println(num1);
            for (int i = 0; i < nums2.length; i++) {
                int num2 = nums2[i];
                if (num1 == num2) {
                    tmp[i] = num1;
                }
                System.out.println("num1 " + num1 + " se compara con " + " " + num2);
            }
        }


        System.out.println("max" + Arrays.toString(tmp));


        List<Integer> num1List = IntStream.of(nums1).boxed().collect(Collectors.toList());

        /*
        List<Integer> num2List = IntStream.of(nums2).boxed().collect(Collectors.toList());
        num2List.retainAll(num1List);




        int maximun = num2List.size();
        System.out.println(maximun);

         */
    }
}
