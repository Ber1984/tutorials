package com.erick.company.jvm.classloader;

import java.io.*;
/*
Java allows developers to define custom class loaders by extending the ClassLoader class.
This is useful for:

Implementing security policies.

Loading classes from specific sources (e.g., databases, networks).
 */
public class MyClassLoaderCustomLoader extends ClassLoader {

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytecode = loadClassData(name);
        return defineClass(name, bytecode, 0, bytecode.length);
    }

    private byte[] loadClassData(String name) {
        String path = name.replace('.', '/') + ".class";
        try (InputStream is = new FileInputStream(path)) {
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            return buffer;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
