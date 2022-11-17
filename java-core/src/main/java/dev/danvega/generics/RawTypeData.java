package dev.danvega.generics;

import java.util.ArrayList;
import java.util.List;

public class RawTypeData {

    public static void methodA() {
        List<String> parameterizedList = new ArrayList<>();
        parameterizedList.add("Hello Folks");
        methodB(parameterizedList);
        System.out.println(parameterizedList);
    }

    public static void methodB(List rawList) { // raw type!
        rawList.add(1);
    }

    public static void main(String[] args) {
        /*
        A raw type is a name for a generic interface or class without its type argument:
        */
        List list = new ArrayList(); // raw type, you don't declare the type of this list. you get a object instance

        list.add(1);
        System.out.println(list);
        list.add("String");
        System.out.println(list);
        if(list.get(0) instanceof Integer) {
            Integer num = (int) list.get(0);
            System.out.println(num);
        }

        List<Integer> listIntegers = new ArrayList<>(); // parameterized type

        //List<Integer> is a parameterized type of interface List<E> while List is a raw type of interface List<E>.

        /*
        Raw types can be useful when interfacing with non-generic legacy code
        Otherwise, though, it's discouraged. This is because:

        They are not expressive
        They lack type safety, and
        Problems are observed at run time and not at compile time
         */


        /*
        Type safety means that the compiler will validate types while compiling, and throw an error if you try to assign the wrong type to a variable.
         */

        RawTypeData.methodA();


    }
}