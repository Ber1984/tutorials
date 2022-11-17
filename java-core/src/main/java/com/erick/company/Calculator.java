package com.erick.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 Calculator that performs the 4 basic operations. add, subtract, multiply and divide integer numbers
 */
public class Calculator {
    private static final String NOT_ALLOWED = "noAllowed";
    private List<String> input() {
        var numbers = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("What operation do you need to do ");
        char operation = scanner.nextLine().charAt(0);
        String result = getOperation(operation); //validate the type of operation

        if(NOT_ALLOWED.equals(result)) throw new IllegalArgumentException("Operation incorrect");

        System.out.println("What numbers do you need to " + result + "\n please separate them by space");
        String[] num = scanner.nextLine().split(" ");

        int max = Math.max(Integer.parseInt(num[0]), Integer.parseInt(num[1]));
        int min = Math.min(Integer.parseInt(num[0]), Integer.parseInt(num[1]));

        numbers.add(0, String.valueOf(max));
        numbers.add(1, String.valueOf(min));
        numbers.add(String.valueOf(operation));

        return numbers;
    }
    private static String getOperation(char operation) {
        String result;
        switch (operation) {
            case '+':   result = "Add"; break;
            case '-' :  result =  "subtract"; break;
            case '*':   result =  "Multiply"; break;
            case '/':   result =  "Divide"; break;
            default:    result = "noAllowed";
        }
        return result;
    }

    private String calculate(List<String> numbers) {
        char operation = numbers.get(2).charAt(0);
        int num = Integer.parseInt(numbers.get(0));
        int num1 = Integer.parseInt(numbers.get(1));

        if(operation == '+') {
            return "The sum is  " + add(num, num1);
        } else if(operation == '-') {
            return "The subtraction " + subtraction(num, num1);
        } else if(operation == '*') {
            return "The multiply is " + multiply(num, num1);
        } else {
            return "The division is " + divide(num, num1);
        }
    }
    private int add(int num, int num2) {
        return num + num2;
    }
    private int subtraction(int num, int num2) {
        return num - num2;
    }
    private int multiply(int num, int num2) {
        return num * num2;
    }
    private int divide(int num, int num2) {
        return num / num2;
    }


    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        boolean keep = false;
        do {
           try {
               List<String> numbers = calculator.input();
               System.out.println(calculator.calculate(numbers));
           } catch (Exception e) {
               System.out.println(e);
               keep = true;
           }
       } while (keep);
    }
}
