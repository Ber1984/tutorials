package com.erick.company.algoritms.com.erick.algoritms;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RepeatedLongestNumber {

    public static void main(String[] args) {
        array();
    }

    private static void array() {
        int[] myArray = {1, 1, 4, 5, 8, 8, 8};

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < myArray.length; i++) {
            int num = myArray[i];
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int max = Collections.max(map.values());

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue() == max){
                System.out.println("Longest:" + entry.getValue());
                System.out.println("Number:" + entry.getKey());
            }
        }

        String s = map.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(x -> "Longest: " + x.getValue() + "\n" + "Number: " +x.getKey())
                .get();
        System.out.println(s);

    }
}
