package com.erick.company.solid.abstraction;

public class FrenchGreeter implements  GreeterService {
    @Override
    public void greet() {
        System.out.println("Bonjour!");
    }
}
