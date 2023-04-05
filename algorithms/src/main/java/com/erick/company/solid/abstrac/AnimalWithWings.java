package com.erick.company.solid.abstrac;

public class AnimalWithWings extends Animal {

    public AnimalWithWings(String name) {
        super(name);
    }

    void fly() {
        System.out.println(name +  " flying");
    }
}
