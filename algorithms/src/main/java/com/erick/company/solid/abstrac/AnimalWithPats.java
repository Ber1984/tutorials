package com.erick.company.solid.abstrac;

public class AnimalWithPats extends Animal {
    public AnimalWithPats(String name) {
        super(name);
    }

    void walk(){
        System.out.println(name + " walking");
    }
}
