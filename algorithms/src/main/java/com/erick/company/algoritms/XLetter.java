package com.erick.company.algoritms;

public class XLetter {
    public static int[][] createX(int n) {
        if (n == 0) {

        }
        int[][] a = {{6, 7, 5, 0, 4}, {3, 8, 4}, {1, 0, 2, 7}, {9, 5}};
        //System.out.println("Valores en fila 1 y columna 5 " + a[3][0]);


        String[][] matrix = new String[n][n];
        //crate a matrix with 5 rows and 5 colums
        /*
        String[][] matrix = {{"X","_","_","_","X"},
                             {"_","X","_","X","_"},
                             {"_","_","X","_","_"},
                             {"_","X","_","X","_"},
                             {"X","_","_","_","X"}
        };
        */
        //Scanner sc = new Scanner(System.in);
        /*
        System.out.println("Write the x");
        System.out.println();
        for (int row = 0; row <matrix.length ; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print("Matrix[" + row + "][" + column + "]= ");
                matrix[row][column] = sc.next();
            }
        }
        */

        float temp = 98.4F;
        System.out.println(temp);


        //System.out.println(t);
        if(temp>98.4){
            System.out.println("SUMMER");
        } else {
            System.out.println("UNKNOWN");
        }


        for (int i = 0; i < 5; i++) {
            var linea = " ";
            for (int j = 0; j < 5; j++) {
                if (i == j || j == 5 - 1 - i) {
                    linea = linea + 'X';
                } else {
                    linea = linea + '_';
                }
            }
            System.out.println(linea);
        }


        System.out.println("Loop matrix");
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column]);
            }
            System.out.println();
        }
        return null;
     
    }


    public static void main(String[] args) {

        createX(5);
    }
}
