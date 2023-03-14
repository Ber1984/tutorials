package com.erick.company.algoritms.com.erick.algoritms.AlgoCademy;

public class MagicalNumber {

    public static void main(String[] args) {
        System.out.println(magicNumber());
    }
    static int digitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            System.out.println("reminder" + sum);
            n /= 10;
        }

        return sum;
    }

    public static int magicNumber() {
        int n = 928435;
        while (n > 9) {
            n = digitSum(n);
        }
        return n;
    }


}
