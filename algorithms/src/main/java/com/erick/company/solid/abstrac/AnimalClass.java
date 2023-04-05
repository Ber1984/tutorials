package com.erick.company.solid.abstrac;

public class AnimalClass {
    public static void main(String[] args) {
        AnimalWithPats lion = new AnimalWithPats("Lion");
        lion.walk();
        AnimalWithWings bird = new AnimalWithWings("Bird");
        bird.fly();

        System.out.println(lion);
        System.out.println(bird);
    }
}
