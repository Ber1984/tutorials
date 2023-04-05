package com.erick.company.solid.abstraction;

public class GermanGreeter implements GreeterService, GreeterWithNameService, FarewallService {



    @Override
    public void greet() {
        System.out.println("Hallo! ");
    }

    @Override
    public void farewall() {}

    @Override
    public void greetWithName(String name) {
        greet();
        System.out.println(name);
    }
}
