package com.erick.company.bigdecimal;

import java.math.BigDecimal;

public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal number = BigDecimal.valueOf(14.45F);
        //int a = 5;
        System.out.println(number.floatValue());
        System.out.println("here");

        Integer a = 5;
        int b  = a;
        System.out.println(b);

        Integer en = 200;
        System.out.println(en);
        en = en + 100;
        System.out.println(en);

        var i = 5;
        var f = 5.5F;
        var c = 'a';//if(i == f) c++;
        //double x = 10 double g = 30;
        byte m = 10;
        m+=5;
        //m = m + 5;
        StringBuilder n1 = new StringBuilder("cadena");
        StringBuilder n2 = new StringBuilder("cadena");
        int s = (n1 == n2) ? 1 : 2;
        System.out.println(s);
        if(n1.equals(n2)){
            System.out.println("Equals");
        }else {
            System.out.println("Not equals");
        }

        String r1 = "cadena";
        System.out.println("Assign to " + r1);

        String r2 = "completa";
         r1 = r1 + r2;
        System.out.println("Assign to " + r1);
        if(r1.equals(r2)){
            System.out.println("Equals");
        } else {
            System.out.println("Not equals");
        }

        System.out.println("6+3="+2+7);
        System.out.println("6+3="+(2+7));

        String completa = (r2.equals("completa")) ? "Yes" : "No";
        int arroba = '@';
        System.out.println(arroba);

        int num = 5;
        final int  num3 = 5;
        switch ("num"){
            case "":
                System.out.println("hello");
                System.out.println();
            case "num3":
                System.out.println(2);

        }

        int x = 100;
        int p = x++;
        int fr = ++x;
        System.out.println(p);
        System.out.println(fr);

    }
}
