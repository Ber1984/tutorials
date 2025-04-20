package com.erick.company.LeetCode.twopointers;

import java.util.HashSet;

public class MergeArrays {

    public static void main(String[] args) {
        System.out.println(mergeArrays(new int[][]{{1,2}, {2,3} , {4,5}}, new int[][]{{1,4}, {3,2} , {4,1}}));
    }

    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        HashSet<HashSet<Integer>> ans = new HashSet();
        boolean found = false;
        for(int i = 0; i < nums1.length; i++) {
            HashSet<Integer> list  = new HashSet<>();
            for (int[] ints : nums2) {
                if (nums1[i][0] == ints[0]) {
                    found = true;
                }
            }
            if (found) {
                list.add(nums1[i][0]);
                list.add(nums1[i][1] + nums2[i][1]);
            } else {
                list.add(nums1[i][0]);
                list.add(nums1[i][1]);
                System.out.println("here" + nums1[i][0]);
            }
            ans.add(list);
            found = false;
        }

        for(int i = 0; i < nums2.length; i++) {
            HashSet<Integer> list  = new HashSet<>();
            for (int[] ints : nums1) {
                if (nums1[i][0] == ints[0]) {
                    found = true;
                }
            }
            if (found) {
                list.add(nums1[i][0]);
                list.add(nums1[i][1] + nums2[i][1]);
            } else {
                list.add(nums2[i][0]);
                list.add(nums2[i][1]);
                System.out.println("here" + nums1[i][0]);
            }
            ans.add(list);
            found = false;
        }

        //System.out.print(ans);


        return convertToArray(ans);
    }

    public static int[][] convertToArray(HashSet<HashSet<Integer>> set) {
        int rows = set.size();
        int[][] result = new int[rows][];
        int rowIndex = 0;

        for (HashSet<Integer> innerSet : set) {
            int cols = innerSet.size();
            result[rowIndex] = new int[cols];

            int colIndex = 0;
            for (int num : innerSet) {
                result[rowIndex][colIndex++] = num;
            }

            rowIndex++;
        }

        return result;
    }
}
