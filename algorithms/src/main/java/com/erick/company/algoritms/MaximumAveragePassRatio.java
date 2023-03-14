package com.erick.company.algoritms;

public class MaximumAveragePassRatio {

    public static void main(String[] args) {
        System.out.println(maxAverageRatio(new int[][]{{2,4},{3,9},{4,5},{2,10}}, 4));
        //System.out.println(String.format("%.5f", maxAverageRatio(new int[][]{{2,4},{3,9},{4,5},{2,10}}, 4)));
        //System.out.println(String.format("%.5f", maxAverageRatio(new int[][]{{1,2},{3,5},{2,2}}, 2)));
    }

    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        double maximumAverage = 0.0, newCurrentAverage;
        double average = currentAverage(classes);

        int numberOfClasses = classes.length;
        main:
        for(int i = 0;i<numberOfClasses;i++) {
            int num1;
            for (int j = 0; j < classes[i].length; j++) {
                int tmp = classes[i][j];
                for (int k = 1; k < classes[j].length; k++) {
                    num1 = classes[i][k];
                    classes[i][k] = num1 + extraStudents;
                }
                classes[i][j] = tmp + extraStudents;
                newCurrentAverage = currentAverage(classes);
                if (newCurrentAverage > average) {
                    maximumAverage = newCurrentAverage;
                    break main;
                }
            }
        }
        return maximumAverage;
    }

    private static double currentAverage(int[][] classes) {
        double sum = 0.0;
        int num, num1 = 0;
        int numberOfClasses = classes.length;

        for(int i = 0;i<numberOfClasses;i++) {
            for(int j = 0;j<classes[i].length;) {
                num = classes[i][j]; //2
               for(int k = 1;k<classes[j].length;k++) {
                   num1 = classes[i][k];
               }
               sum+= (double) num / num1;
               num1 = 0;
               break;
            }
        }
        return  sum / numberOfClasses;
    }
}
