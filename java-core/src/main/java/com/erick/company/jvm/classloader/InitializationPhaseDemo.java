package com.erick.company.jvm.classloader;
/*
3. Initialization Phase
Executes the static initializers (<clinit> method).

Executes static blocks in the order they appear in the class.

Output

First static block
Second static block
Main method

 */
public class InitializationPhaseDemo {
    static {
        System.out.println("First static block");
    }

    static {
        System.out.println("Second static block");
    }

    public static void main(String[] args) {
        System.out.println("Main method");
    }
}
