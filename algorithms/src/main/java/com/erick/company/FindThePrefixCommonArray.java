package com.erick.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FindThePrefixCommonArray {
    public static void main(String[] args) {
        System.out.println(findThePrefixCommonArray(new int[]{2,3,1}, new int[]{3,1,2}));
    }

    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        Map<Integer, Integer> map = new HashMap();
        ArrayList<Integer> list = new ArrayList();
        int[] ans = new int[B.length];
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1); // 1
            map.put(B[i], map.getOrDefault(B[i], 0) + 1); // 3

            if(map.containsKey(A[i]) && map.containsKey(B[i])) {

                ans[i] = map.size();
            }



        }

        return ans;
    }
}
