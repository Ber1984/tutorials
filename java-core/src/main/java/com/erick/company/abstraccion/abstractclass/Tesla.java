package com.erick.company.abstraccion.abstractclass;

public class Tesla extends Car {

    @Override
    public void typeOfBrakes() {
        System.out.println("Tesla - ABS");
    }

    @Override
    public void isAutonomousDriving() {
        System.out.println("Yes,I am");
    }

    @Override
    public void start() {
        System.out.println("Starting Tesla");
    }

    @Override
    public void stop() {
        System.out.println("Stopping Tesla");
    }
}
