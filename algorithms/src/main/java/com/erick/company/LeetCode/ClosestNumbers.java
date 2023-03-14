package com.erick.company.LeetCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClosestNumbers {
    public static void main(String[] args) {
        closestNumbers(Arrays.asList(6, 2, 4, 10));
    }

    public static void closestNumbers(List<Integer> numbers) {
        int i = 0, j =  1;
        Collections.sort(numbers);
        int min = Math.abs(numbers.get(1) - numbers.get(0));

        while(i < numbers.size()) {
            if(j == numbers.size()){
                break;
            }
            int num = numbers.get(i);
            int sub = Math.abs(numbers.get(j) - num);
            min = Math.min(min, sub);
            i++;
            j++;
        }

        for(int k = 0; k < numbers.size() - 1; k++) {
            if(numbers.get(k+1) - numbers.get(k) == min) {
                System.out.print(numbers.get(k));
                System.out.print(numbers.get(k+1));
            }
         }
    }
}

