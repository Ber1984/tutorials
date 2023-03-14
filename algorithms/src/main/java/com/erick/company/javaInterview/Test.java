package com.erick.company.javaInterview;

public class Test {
    public static void main(String[] args) {
        //int x = 1;
        //while (x <= 10)
        //System.out.println(++x);

        //int x = 10;
        //int y = 3;
        //System.out.println(x%y);


        //------------------------------------------------------
        /*
        int x = 0;
        do {
            System.out.println(x);
            x++;
        } while (x < 10);

        int y = 0;
        while (y < 10) {
            System.out.println(y);
            y++;
        }

         */

        //int z = x++ + y;

        /*
        int x = 5, y = 5;
        y /= ++x;
        System.out.println("division" + y);

        int total = 10;
        int contador = 4;

        total -= --contador;
        System.out.println(total);

         */

        int x = 0;
        int y = 0;

        while(x<5){
            y += x;
            x++;
        }
        System.out.println(y);



    }
}
