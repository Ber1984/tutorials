package com.erick.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindMissingAndRepeatedValues {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findMissingAndRepeatedValues(new int[][]{{1,3},{2,2}})));
        System.out.println(Arrays.toString(findMissingAndRepeatedValues(new int[][]{{9,1,7},{8,9,2},{3,4,6}})));
    }

    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int repeatedInt = 0, missingInt = 0;
        boolean repeated = true;

        Map<Integer, Integer> map = new HashMap();
        for(int[] grid2 : grid) {
            for(int num : grid2) {
                if(map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                } else {
                    map.put(num,  1);
                }
                if(map.containsKey(num) && map.get(num) > 1) {
                    repeated = false;
                    repeatedInt = num;
                    break;
                }
            }

        }
        int i = 1;
        while (i <= map.size()) {
            if(!map.containsKey(i)) {
                missingInt = i;
            }
            i++;
        }

        return new int[]{repeatedInt, missingInt == 0 ? i : missingInt};
    }


}
