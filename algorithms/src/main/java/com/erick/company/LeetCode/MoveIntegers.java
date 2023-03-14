package com.erick.company.LeetCode;

import java.util.Arrays;

public class MoveIntegers {

    public static void main(String[] args) {
        /*
        un array[1,2,2,2,3,4,5]MOVE = 2
        entonces tenia que mover todos los elementos que correspondieran a 2 al final del array
        osea que quedaria asi:[1,2,4,5,2,2,2,2]
         */
        moveIntegers();
    }

    static void moveIntegers() {
        int[] array = {1, 2, 2, 2, 3, 4, 5};  //2
        // order the array Arrays.sort();
        int i = 0,j = array.length;
        while(i < j) {
            if(array[i] == 2 && array[j] != 2) {
                int number = array[i];
                int swap = array[j];
                array[j] = number;
                array[i] = swap;
            }        i++; j--;
        }    System.out.println(Arrays.toString(array));}
    }
