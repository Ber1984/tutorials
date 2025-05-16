package com.erick.company.jvm.classloader;
/*
2. Linking Phase
Linking is divided into three steps:

Verification:

Ensures the bytecode follows JVM specifications.

Prevents loading of corrupted or malicious classes.

Preparation:

Allocates memory for class variables and assigns default values.

Resolution:

Replaces symbolic references with direct memory references.

Preparation Phase:

x = 0, y = 0 (default values).

Initialization Phase:

x = 10, y = 20 (static block execution).


Output
Static block executed
x = 10
y = 20



 */
public class LinkingPhaseDemo {

    static int x = 10;
    static int y;

    static {
        y = x * 2;
        System.out.println("Static block executed");
    }

    public static void main(String[] args) {
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }
}
