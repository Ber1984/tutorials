package com.erick.company.oracleCertification;

public class Ex12 {
    public static void main(String[] args) {
        int x = 10;
        int y = new Ex12().change(x);
        System.out.println(x + y);
    }
    int change(int x){
        int r = x;
        r=12;
        return r;
    }
}
