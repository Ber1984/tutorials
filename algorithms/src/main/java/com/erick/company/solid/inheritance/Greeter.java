package com.erick.company.solid.inheritance;

import java.io.PrintStream;

public class Greeter {

    private PrintStream target;

    public Greeter(PrintStream target) {
        this.target = target;
    }

    public void greet() {
        System.out.println("Hello, World!");
    }
}
