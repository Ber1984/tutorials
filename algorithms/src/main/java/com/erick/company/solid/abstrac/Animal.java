package com.erick.company.solid.abstrac;

import java.io.PrintWriter;

public class Animal {

    protected String name;



    public Animal(String name) {
        this.name = name;
    }

    void eat(){
        System.out.println("Animal eating");
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}
