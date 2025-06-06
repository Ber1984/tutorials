package com.erick.company.LeetCode;

import java.util.Arrays;

public class SetZeroes {

    public static void main(String[] args) {
        setZeroes(new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}});
        //setZeroes(new int[][]{{1,1,1},{1,0,1},{1,1,1}});
        //setZeroes(new int[][]{{0,1}});
    }

    public static void setZeroes(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i], false);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0 && !visited[i][j]) {
                    visited[i][j] = true;
                    columnToZero(matrix, j, visited);
                    rowToZero(matrix, i, visited);

                }
            }
        }

        //System.out.println(Arrays.toString(matrix));

    }

    private static void columnToZero(int[][] matrix,  int currentCol, boolean[][] visited) {
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][currentCol] != 0) {
                matrix[row][currentCol] = 0;
                visited[row][currentCol] = true;
            }
        }

    }

    private static void rowToZero(int[][] matrix, int currentRow, boolean[][] visited) {
        for (int col = 0; col < matrix[currentRow].length; col++) {
                if (matrix[currentRow][col] != 0) {
                    matrix[currentRow][col] = 0;
                    visited[currentRow][col] = true;
                }

        }
    }
}
