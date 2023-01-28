package LeetCode;

import jdk.swing.interop.SwingInterOpUtils;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverseInteger());
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

    public static int reverseInteger() {
        int x = 54321;
        int result = 0;
        int prev = 0;
        /* 123 binary speaking  has 32 bits between 1 and 0 1010101010111101101 til getting 32 bits  */
        while (x != 0) {
            System.out.println("x" + x);
            int cur = x % 10;
            System.out.println("cur" + cur);
            x /= 10;
            System.out.println("cur / " + x);
            result = result * 10 + cur;
            System.out.println("result" + cur);
            if ((result - cur) / 10 != prev) return 0;
            prev = result;
        }
        return result;
    }

}
