package com.erick.company.LeetCode;

public class Main {
    public static void main(String[] args) {
        //duplicateZeros(new int[]{1,0,2,3,0,4,5,0});
        findIndices(new int[]{8,8}, 1, 1);
    }

    public static void duplicateZeros(int[] arr) {
        /*
        List<Integer> ans = new ArrayList();

        for(int num : arr) {
            if(ans.size() < arr.length) {
            if(num == 0) {
                ans.add(num);
                ans.add(num);
            } else {
                ans.add(num);
            }
            }

        }
        System.out.print(ans);
        */
        if (arr == null || arr.length == 0) return;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                for (int j = arr.length - 1; j > i; j--) {
                    arr[j] = arr[j-1];
                }
                i++; // we don't want to traverse over the duplicate zero
            }
        }

    }

    public static int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int n = nums.length;
        if(n == 1 && indexDifference == 0 && valueDifference == 0) return new int[]{0,0};
        int i = 0, j = 1;

        /*
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
              if(Math.abs(i - j) >= indexDifference && Math.abs(nums[i] - nums[j]) >= valueDifference ) {
                return new int[]{i,j};
            }
        }
        }
        */


        while(i < n) {
            if(j > n - 1) {
                i++; j = i + 1;
            }

            if(j < n && Math.abs(i - j) >= indexDifference && Math.abs(nums[i] - nums[j]) >= valueDifference ) {
                return new int[]{i,j};
            }

            j++;
        }

        return new int[]{-1,-1};

    }
}

