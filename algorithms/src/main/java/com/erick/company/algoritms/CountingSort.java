package com.erick.company.algoritms;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] numbers = {0,4,2,2,0,0,1,1,0,1,0,2,4,2};
        int max = numbers[numbers.length - 1];
        System.out.println(max);
        int m = max + 1;
        int aux[] = new int[5];


        for ( int i = 0; i <5 ; i++) {
            int count = 0;
            for (int j = 0; j<numbers.length ; j++) {
                if(numbers[j] == i){
                    count++;
                }
            }
            aux[i] = count;
        }
        System.out.println( Arrays.toString(aux));
    }
}
