package com.erick.company;

public class Test {

    public static void main(String[] args) {
        getLucky("zbax", 2);
    }

    public static int getLucky(String s, int k) {
        StringBuilder number = new StringBuilder();
        for (Character value : s.toCharArray()) {
            number.append(value - 'a' + 1);
        }
        // System.out.print(number.toString());
        int i = 1, sum = 0;
        while (i <= k) {
            System.out.print(number.toString());
            for (char num : number.toString().toCharArray()) {
                sum += num - '0';
            }
            System.out.print(sum);
            number = new StringBuilder(String.valueOf(sum));

            i++;

            if(i <= k) {
                sum = 0;
            }
        }

        System.out.print(number);
        return 1;
    }
}
