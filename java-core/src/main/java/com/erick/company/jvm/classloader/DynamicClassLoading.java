package com.erick.company.jvm.classloader;

/*
 Dynamic Class Loading using Class.forName()
Dynamically loads a class at runtime.

This is useful for JDBC drivers, plugins, etc.

output
Class loaded: java.lang.String

 */
public class DynamicClassLoading {

    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("java.lang.String");
            System.out.println("Class loaded: " + clazz.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
