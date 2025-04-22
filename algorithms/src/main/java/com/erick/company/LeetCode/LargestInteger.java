package com.erick.company.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LargestInteger {
    public static void main(String[] args) {
        System.out.println(largestInteger(64));

        var department = 31;
switch(department){
case 13:
case 59:
System.out.print("North, ");
default:
case 69:
case 75:
System.out.print("Seine, ");
case 'a' | 'b':
System.out.print("Corsica");
}

    }

    public static int largestInteger(int num) {
        int ans = 0, start = 0, end = 0;
        PriorityQueue<Integer> max_heap = new PriorityQueue(Comparator.reverseOrder());
        char[] numbers = String.valueOf(num).toCharArray();
        if (numbers.length == 1) return numbers[0] - '0';
        end = numbers.length - 1;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if(numbers[i] - '0' > 0 && numbers[j] - '0' > 0 && isEven(numbers[i] - '0', numbers[j] - '0')) {
                    int tmp = numbers[j]; //3
                    numbers[j] = numbers[i];
                    numbers[i] = (char) tmp;
                    String m = "";
                    for(char nu : numbers) {
                        m  += nu - '0';
                    }

                    max_heap.add(Integer.parseInt(m));
                }
            }
        }


        System.out.println(max_heap);
        return !max_heap.isEmpty()  ? max_heap.peek() : num;
    }

    private static boolean isEven(int num , int num2) {
        if(num % 2 == 0 && num2 % 2 == 0)  return true; //even
        if(num % 2 != 0 && num2 % 2  != 0 ) return true;
        return false;
    }
}
