package com.erick.company.Prodigious;

import java.util.Arrays;
import java.util.List;

public class Test1 {

    public static final String GOODBAY = "Goodbay";
    String hola = "c";
    public static void main(String[] args) {
        List list = Arrays.asList("Bob", "Bill", "Ben");
        if (list instanceof Object) {
            System.out.println("true");
        }

        String  message = "Welcome";
        String message2 = message;
        list.forEach(name -> System.out.println(message2 + "" + name));
        message = GOODBAY;
        list.forEach(name -> System.out.println(name));
        Test1 test1 = new Test1();


    }
}
