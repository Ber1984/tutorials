package com.erick.company.solid.abstraction;

public class AbstractionClass {

    public static void main(String[] args) {

        GreeterService french = new FrenchGreeter();
        GermanGreeter german = new GermanGreeter();
        german.greetWithName("Erick");


    }
}
