package com.erick.company.solid.inheritance;

import java.io.PrintStream;

public class FrenchGreeter extends Greeter {

    public FrenchGreeter(PrintStream target) {
        super(target);
    }

    @Override
    public void greet() {
        System.out.println("Bonjour!");
    }
}
