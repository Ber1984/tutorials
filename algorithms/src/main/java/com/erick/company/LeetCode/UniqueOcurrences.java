package com.erick.company.LeetCode;

import java.util.*;

public class UniqueOcurrences {

    public static void main(String[] args) {
        uniqueOccurrences(new int[]{1,2,2,1,1,3}); //two loops
    }
    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 1;
        for(int i = 0;i <arr.length; i++) {
            int num = arr[i];
            if(map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        //Find duplictes in the values of hashmap
        List<Integer> items = new ArrayList<>(map.values());
        System.out.print(items);
        for(int j = 0;j<items.size();j++) {
            for(int k = 1;k<items.size();k++) {
                if(j != k) {
                    if(items.get(j) == items.get(k)) {
                        System.out.print("here" + items.get(j) + items.get(j));
                        return false;

                    }
                }


            }

        }

        return true;
    }

    public boolean uniqueOccurrencesOneLoop(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0;i <arr.length; i++) {
            int num = arr[i];
            if(map.containsKey( arr[i])) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        List<Integer>  items = new ArrayList<>(map.values());
        Collections.sort(items);
        int o = 0, s = 1;
        while(o < items.size()) {
            if(s == items.size()) break;
            if(items.get(o) == items.get(s)) {
                System.out.print("here" + items.get(o) + items.get(s));
                return false;
            } else {
                o++; s++;
            }
        }
        return true;
    }
}
