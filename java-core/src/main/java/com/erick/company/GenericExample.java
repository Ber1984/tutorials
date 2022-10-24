package com.erick.company;

public class GenericExample<T> {  // We use < > to specify Parameter type
    // To create an instance of generic class
    //BaseType <Type> obj = new BaseType <Type>()
    // An object of type T is declared

    /*
    The type parameters naming conventions are important to learn generics thoroughly. The common type parameters are as follows:

    T – Type
    E – Element
    K – Key
    N – Number
    V – Value
     */
    T obj;

    GenericExample(T obj) {
        this.obj = obj;
    } // constructor

    public T getObject() {
        return this.obj;
    }

    public static void main(String[] args) {

        // instance of Integer type
        GenericExample<Integer> iObj = new GenericExample<>(15);
        System.out.println(iObj.getObject());

        // instance of String type
        GenericExample<String> sObj
                = new GenericExample<String>("GeeksForGeeks");
        System.out.println(sObj.getObject());
    }
}
