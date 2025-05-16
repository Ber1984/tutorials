package com.erick.company.LeetCode.bitshifting;

public class IsPowerOfTwo {

    /*
    https://chatgpt.com/c/681e07f6-fe18-8004-aa73-3091b8efb70c
     */

    /*
    Yes, this is a common and very efficient way to determine if a number is a power of two using bit manipulation. Let's break it down step-by-step.

✅ Understanding the Bit Manipulation Approach:
The Key Expression:

return ((n & (n - 1)) == 0);
This expression leverages a unique property of powers of two in binary representation.

✅ Binary Representation of Powers of Two:
Powers of two have a unique pattern in binary:

2
0
=
1
2
0
 =1: 0001

2
1
=
2
2
1
 =2: 0010

2
2
=
4
2
2
 =4: 0100

2
3
=
8
2
3
 =8: 1000

2
4
=
16
2
4
 =16: 10000

Notice that each power of two has exactly one bit set to 1, and all the other bits are 0.

✅ Binary Representation of
𝑛
−
1
n−1:
Now, let's look at how subtracting 1 affects the binary representation of a power of two:

1 (0001) - 1 = 0 (0000)

2 (0010) - 1 = 1 (0001)

4 (0100) - 1 = 3 (0011)

8 (1000) - 1 = 7 (0111)

16 (10000) - 1 = 15 (01111)

Notice that the binary representation of n - 1 flips all the bits after the least significant 1 bit, converting it to 0 and turning all previous 0s to 1s.

✅ Applying the Bitwise & Operator:
Now, let's see what happens when we perform the bitwise AND operation between n and n - 1:

n = 8 → 1000

n - 1 = 7 → 0111

   1000
&  0111
--------
   0000

Result is 0, which means 8 is a power of two.

If n is not a power of two, then the binary representation of n will have more than one 1 bit, and the bitwise AND operation will not result in 0.

✅ Example: Not a Power of Two
For n = 10:

n = 10 → 1010

n - 1 = 9 → 1001

markdown
Copy
Edit
   1010
&  1001
--------
   1000 (not zero)
Since the result is not zero, 10 is not a power of two.

✅ Why n <= 0 Check?
Negative numbers are not powers of two.

Zero is not a power of two.

Thus, the if (n <= 0) condition handles these cases upfront.

✅ Complexity Analysis:
Time Complexity: O(1), as bitwise operations are constant-time operations.

Space Complexity: O(1), no extra space is used.


     */
    public static void main(String[] args) {

    }

    /*
     2 * 1 = 2
     2 * 2 = 4
     2 * 2 * 2 = 8
     2 * 2 * 2 * 2 = 8
     */
    //Using Integer.bitCount() this is method will count positive bits (1) in the binary representation of the number
    public boolean isPowerOfTwo(int n) {
        //String representation of the number
        /*
        3 -  0011 = 2 positive bits
        4 -> 0100 -> 1
        8 -> 1000 -> 1
        I just need to count the number of positive bits to 1 and return true
         */


        //reminder and divident method
        if(n < 0) return false; //handling negative numbers because it uses two's complement
        /*
        For example:

The binary representation of -2147483648 is:
10000000 00000000 00000000 00000000

Here, the most significant bit (the leftmost 1) represents the sign bit, indicating that the number is negative. Thus, Integer.bitCount(-2147483648) is 1, but it is not a power of two.
         */

        /*
        Handling Negative Numbers:
A power of two is always positive. Therefore, before applying the bitCount() check, we need to ensure that the input is positive. We can do that by adding an early return condition:
         */

        //Check if there is only one set bit
        if(Integer.bitCount(n) == 1) {
            return true;
        }

        /*
         Why This Works:
The Integer.bitCount(n) method counts the number of 1 bits in the binary representation.

A power of two has exactly one set bit in its binary representation.
For example:

2^0 = 1 → 00000001 (1 set bit)

2^1 = 2 → 00000010 (1 set bit)

2^2 = 4 → 00000100 (1 set bit)

2^3 = 8 → 00001000 (1 set bit)
         */
        return false;

    }

    public boolean isPowerOfTwoBitMasking(int n) {
        //reminder and divident method
        //bit manipulation
        if(n <= 0) return false; //handling negative numbers


        return ((n&(n - 1)) == 0);
    }
}
