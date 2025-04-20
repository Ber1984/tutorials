package com.erick.company.LeetCode.simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        System.out.println(fractionAddition("1/3-1/2"));
    }

    public static String fractionAddition(String expression) {
        String numerator = "", denominator = "", ans = "", operand = "+";
        List<String> expressions = new ArrayList();
        int i = 0;
        if(expression.charAt(0) == '-') {
            numerator += expression.charAt(i);
            i = 1;
        }

        while (i < expression.length()) {
            // Check if the character is not '+' and not '-'
            if (expression.charAt(i) != '+' && expression.charAt(i) != '-' && expression.charAt(i) != '/') {
                numerator += expression.charAt(i);
                System.out.println(numerator);
            } else {
                System.out.println("numerator");
                expressions.add(numerator);  // Add the accumulated numerator to the list
                expressions.add(String.valueOf(expression.charAt(i)));  // Add the operator to the list
                numerator = "";  // Reset numerator for the next number
            }
            i++;

            // Add the last accumulated numerator to the list if we reach the end of the expression
            if(i == expression.length()) {
                expressions.add(numerator);
            }
        }

        double sum = 0.0;
        double currentFraction = 1.0; // This will store the current fractio
        int count = 0;
        double[] dp = new double[expressions.size()];

        for (String ch : expressions) {
            // Check if the string is a number (numerator or denominator)
            if (!ch.equals("/") && !ch.equals("+") && !ch.equals("-")) {
                if (operand.equals("/")) {
                    currentFraction /= Double.parseDouble(ch); // Divide by the denominator
                } else {
                    currentFraction = Double.parseDouble(ch); // Initialize with numerator
                }
            } else {
                if (ch.equals("+") || ch.equals("-")) {
                    // Handle addition and subtraction
                    if (operand.equals("+")) {
                        sum += currentFraction;
                    } else if (operand.equals("-")) {
                        sum -= currentFraction;
                    }
                    // Store the result in dp array
                    dp[count++] = sum;

                    // Update the operand for the next operation
                    operand = ch;
                    currentFraction = 0.0; // Reset the fraction for the next part
                } else if (ch.equals("/")) {
                    // Update operand to divide
                    operand = "/";
                }
            }
        }

// Handle the last fraction in the expression
        if (operand.equals("+")) {
            sum += currentFraction;
        } else if (operand.equals("-")) {
            sum -= currentFraction;
        }
        dp[count] = sum;

// Final result is stored in `sum`
        System.out.println("Final sum: " + sum);

        System.out.print(Arrays.toString(dp));
        //System.out.println(expressions);
        //System.out.println(denominator);
        //System.out.println(operand);
        return ans;

    }
}
