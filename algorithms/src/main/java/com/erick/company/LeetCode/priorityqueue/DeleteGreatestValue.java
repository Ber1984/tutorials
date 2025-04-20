package com.erick.company.LeetCode.priorityqueue;

import java.util.ArrayList;
import java.util.Collections;

public class DeleteGreatestValue {

    public static void main(String[] args) {
        deleteGreatestValue(new int[][]{{1,2,4},{3,3,1}});
    }

    public static int deleteGreatestValue(int[][] grid) {
        //1 1 2 3 3 4
        int ans = 0;
        ArrayList<Integer> newGrid = new ArrayList();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                newGrid.add(grid[i][j]);
            }
        }

        Collections.sort(newGrid);
        int  k = newGrid.size() - 1, p = k - 1;
       while (k >= 0) {
           ans += Math.max(newGrid.get(k), newGrid.get(p)); //4
           k -= 2;
           p = k - 1;
       }



        return ans;
    }
}
