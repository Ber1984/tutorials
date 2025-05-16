package com.erick.company.jvm.classloader;

/*
1. Loading Phase
The class loader locates the .class file using the classpath or other sources.

The .class file is then read and converted into a Class object.

javac MyClass.java
java MyClass

Output
MyClass is loaded

 */
public class ClassLoaderDemo {

    public static void main(String[] args) {

    }

    static {
        System.out.println("MyClass is loaded");
    }
}
