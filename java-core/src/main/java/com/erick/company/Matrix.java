package com.erick.company;

public class Matrix {

    public static void main(String[] args) {
        /*
        1, 3, 1 / 0 - 2
        1, 5, 2 / 1 - 1
        2, 3, 2   2 - 0
         */
        int[][] array = new int[][]{{1,3,1},{1,5,2}, {2,3,2}}; //2 * 3

        runCols(array);
        runDiagRight(array);
        runDiagLeft(array);

    }

    private static void runCols(int[][] array) {
        int sum = 0;
        for(int i = 0; i< array.length; i++) {
            for(int k = 0;k < array.length; k++) {
                sum+= array[k][i]; //1
             }
        }
        System.out.println("La suma total es " + sum);
    }

    private static void runDiagRight(int[][] array) {
        int sum = 0;
        int i = 0;
        while (i < array.length ) {
            sum+= array[i][i]; //1
            i++;
        }
        System.out.println("La suma de diagonals es " + sum);
    }

    private static void runDiagLeft(int[][] array) {
        int sum = 0, i = 0, j = array.length - 1;
        while (i <= array.length - 1) {
            sum+= array[i][j];
            i++;
            j--;
        }
        System.out.println("La suma de diagonals left es " + sum);
    }
}
