package com.erick.company.solid.abstraction;

import java.io.PrintStream;

public class Greeter implements GreeterService {

    private PrintStream target;

    public Greeter(PrintStream target) {
        this.target = target;
    }

    public void myGreet() {

    }
    @Override
    public void greet() {
        System.out.println("Bonjour!");
    }
}
