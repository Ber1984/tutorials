package com.erick.company.LeetCode.backtracking.math;

/*
Yes, your code has a few issues:

Incorrect Use of the Stack: You are pushing each digit into the stack but not actually constructing the reversed number.

Incorrect Return Value: You are returning x, which is 0 at the end of the loop, instead of the reversed number.

Handling Negative Numbers: You are not accounting for negative numbers.

Overflow Handling: If the reversed number exceeds the int range, the method should return 0 as per the typical LeetCode-style problem for reversing integers.

  Explanation:
Overflow Handling: We use a long to handle potential overflow. If the value exceeds the int range, we return 0.

Constructing the Reversed Number: We build the reversed number directly without using a Stack.


is performing a mathematical operation to construct the reversed number, not string concatenation.

✅ How It Works:
reversed * 10 shifts the digits to the left, effectively increasing the place value by one digit (like moving from units to tens, tens to hundreds, etc.).

+ digit adds the current digit to the new least significant position.

Example:
For the input 123:

Step-by-step Calculation:

First Iteration:

x = 123

digit = 123 % 10 = 3

reversed = 0 * 10 + 3 = 3

x = 123 / 10 = 12

Second Iteration:

x = 12

digit = 12 % 10 = 2

reversed = 3 * 10 + 2 = 32

x = 12 / 10 = 1

Third Iteration:

x = 1

digit = 1 % 10 = 1

reversed = 32 * 10 + 1 = 321

x = 1 / 10 = 0

So, the resulting reversed value is 321.
 */
public class ReverseInteger {

    public static void main(String[] args) {

    }

    private int reverse(int x) {
        long reversed = 0L;

        while (x != 0) {
            int digit = x % 10; //3
            reversed = reversed * 10 + digit;
            if(reversed > Integer.MAX_VALUE || reversed < Integer.MAX_VALUE) {
                return 0;
            }
            x /= 10;
        }

        return (int) reversed;


    }
}
