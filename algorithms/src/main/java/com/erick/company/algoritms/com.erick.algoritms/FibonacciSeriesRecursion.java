package com.erick.company.algoritms.com.erick.algoritms;

public class FibonacciSeriesRecursion {
    private static long[] fibonacciCache;
    public static void main(String[] args) {
        // f(n) = f(n - 1) + f(n - 2)

        int n = 30;
        fibonacciCache = new long[n + 1];
        for (int i = 0; i < n; i++) {
            //System.out.print(fibonacci(i) + " ");

        }
        fib(6);
    }

    private static long fibonacci(int n) {
         if(n <= 1) { //base case
             return n;
         }
         if(fibonacciCache[n] != 0) {
             return fibonacciCache[n];
         }
         long nthFibonacciNumber = fibonacci(n - 1) + fibonacci(n - 2); // store and look it up later
          fibonacciCache[n] = nthFibonacciNumber;

        return nthFibonacciNumber;
    }

    public static int fib(int n) {
        if(n == 1) return 1;
        int a = 0, b = 1, sum = 0;
        while(n > 1) {
            sum = a + b;
            a = b;
            b = sum;
            n--;
        }

        return sum;
    }
}
