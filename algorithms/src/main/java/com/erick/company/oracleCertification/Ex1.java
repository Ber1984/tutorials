package com.erick.company.oracleCertification;

public class Ex1 {
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6};

        int i = a.length - 1;
        while (i>=0){
            System.out.println(a[i]);
            i--;
        }

        System.out.println(a instanceof Object);
    }
}
