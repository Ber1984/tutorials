package com.erick.company.solid.inheritance;

import java.io.PrintStream;

public class GermanGreeter extends Greeter {

    public GermanGreeter(PrintStream target) {
        super(target);
    }

    @Override
    public void greet() {
        System.out.println("Hallo!");
    }
}
