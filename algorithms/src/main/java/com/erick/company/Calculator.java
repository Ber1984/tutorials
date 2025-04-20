package com.erick.company;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Calculator {

    public static void main(String[] args) {
        String s = "3+5 / 2".replaceAll(" ", "");
        StringBuilder substring = new StringBuilder();
        LinkedHashMap<Integer, String> map = new LinkedHashMap(); //300+
        int i = 0, j = 0, count = 0;
        //sliding window
        while(i < s.length()) {
            if(j == s.length()) break;
                if(Character.isDigit(s.charAt(j))) {
                    substring.append(s.charAt(j)); //300
                    j++;
                    if(i == s.length() - 1)  map.put(count++, substring.toString());
                } else {
                    map.put(count++, substring.toString());
                    substring.setLength(0);
                    substring.append(s.charAt(j));
                    map.put(count++, substring.toString());
                    substring.setLength(0);
                    i = j + 1;
                    j = i;
                }
        }
        int sum = 0;
        String operation = "";
        ArrayList<Integer> operands = new ArrayList<>();
        for(String val : map.values()) {

           if(!val.equals("+") || !val.equals("-") || !val.equals("*") || !val.equals("/")) {
               operands.add(Integer.parseInt(val));
               if(operation.equals("divison")) {
                   sum += operands.get(0) / operands.get(1);
                   operands.clear();
               }
               if(operation.equals("add")) {
                   sum += operands.get(0) + operands.get(1);
                   operands.clear();
               }
               if(operation.equals("multi")) {
                   sum += operands.get(0) * operands.get(1);
                   operands.clear();
               }
               if(operation.equals("sub")) {
                   sum += operands.get(0) - operands.get(1);
                   operands.clear();
               }
           } else {
               switch (val) {
                   case "+" :
                       operation = "add";
                       break;
                   case "-" :
                       operation = "sub";
                       break;
                   case "*" :
                       operation = "multi";
                       break;

                   case "/" :
                       operation = "division";
                       break;

               }
           }
        }
        System.out.println(map);
        System.out.println(sum);
    }
}
