package com.erick.company.LeetCode;

public class PrimePalindrome {
    public static void main(String[] args) {

        /*
        for (int i = 13; i > 0; i++) {
            System.out.println("numbers" + i);
        }
        int i = 13;
        while (i > 0){
            i++;
            System.out.println("numbers" + i);
        }

         */

        /*
        int i = 0;
        int num = 0;
        String prime = "";
        for (i = 13; i > 0; i++) {
            int counter = 0;
            for (num = i; num >= 1; num--) {
                if (i % num == 0) {
                    counter++;
                }
            }
            if (counter == 2) {
                int reversed_int = 0;
                while (i > reversed_int) {
                    int pop = i % 10;
                    i /= 10;
                    reversed_int = (reversed_int * 10) + pop;
                }

                if (i == reversed_int || i == reversed_int / 10) {
                    System.out.println(i);
                }
            }
        }


         */

        int num = 13, reversed = 0;

        for(;num != 0; num /= 10) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
        }

        System.out.println("Reversed Number: " + reversed);

/*
        int i = 0;
        int num = 0;
        int palindrome = 0;
        for (i = n; i > 0; i++) {
            int counter = 0;
            for (num = i; num >= 1; num--) {
                if (i % num == 0) {
                    counter++;
                }
            }
            if (counter == 2) {

                int num2 = i, reversed = 0;
                for (; num2 != 0; num2 /= 10) {
                    int digit = num2 % 10;
                    reversed = reversed * 10 + digit;
                }

                if (i == reversed || i == reversed / 10) {
                    palindrome = reversed;
                    System.out.print("reverse_" + reversed);
                }


            }


        }

 */

    }
}
