package com.erick.company;

public class CountServers {
    public static void main(String[] args) {
        System.out.println((countServers(new int[][]{{
            1,1,0,0},
                {0,0,1,0},
                {0,0,1,0},
                {0,0,0,1}
        })));
    }

    public static int countServers(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[] rowCount = new int[rows];
        int[] colCount = new int[cols];

        // Count the number of servers in each row and column
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        int ans = 0;
        // Check each server and count it if it's part of a connection
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1)) {
                    ans++;
                }
            }
        }

        return ans;
    }

}
