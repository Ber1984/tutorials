package com.erick.company.LeetCode;

public class WateringPlants {
    public static void main(String[] args) {
        //System.out.println(wateringPlants(new int[]{2,2,3,3},5));
    }

    public static int wateringPlants(int[] plants, int capacity) {
        int cap = capacity;
        int steps = 0;
        for(int i = 0; i<plants.length; i++){
            if(plants[i]<= cap){
                cap = cap - plants[i];
                steps++;
            }else {
                steps += i*2;
                cap = capacity;
                i = i-1;
            }
        }
        return steps;
    }
}
