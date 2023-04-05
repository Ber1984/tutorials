package com.erick.company.LeetCode;

import java.util.Arrays;

public class NumRescueBoats {
    public static void main(String[] args) {
        System.out.println("boats" + numRescueBoats(new int[]{5,1,4,2}, 6));
    }
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people); //2,3,7
        int i = 0,  j = i + 1,  boat = 0, num2 = 0;;
        while(i < people.length) {
            if(j > people.length) {
                break;
            }
            int num1 = people[i];
            if(j <= people.length - 1) {
                num2 = people[j];
            }
            int sum = num1 + num2;
            if(sum == limit && num1 == num2) {
                boat++; i += 2; j = i + 1;
            }else if(sum > limit) {
                boat += 2;
                i += 2; j = i + 1;
            } else {
                boat++;
                i += 2; j = i + 1;
            }
            num1 = 0;
            num2 = 0;
        }
            return boat;
        }
}
