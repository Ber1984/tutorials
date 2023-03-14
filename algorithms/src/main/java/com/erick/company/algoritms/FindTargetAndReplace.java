package com.erick.company.algoritms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindTargetAndReplace {

    public static void main(String[] args) {
        int[] tmps = {1,2,3,4,5};
        System.out.println(Arrays.toString(tmps));
        Arrays.toString(findAndReplace(new int[][]{{1, 2, 3}, {4 , 5, 6}, {7, 8, 9}}, 9));
    }

    static int[][] findAndReplace(int[][] data, int target) {
        int rows = data.length;
        int columns = data[0].length;

        Set targetColumns = new HashSet<>();
        Set targetRows = new HashSet<>();

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                if (data[i][j] == target) {
                    targetColumns.add(i);
                    targetRows.add(j);
                }
            }
        }

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                if (targetColumns.contains(i) || targetRows.contains(j)) {
                    data[i][j] = 0;
                }
            }
        }

        return data;
    }
}
