package com.erick.company.collections;

import java.util.Vector;
import java.util.function.Function;

public class VectorTest {
    public static void main(String[] args) {
        /*
     Java Vector
Vector is like the dynamic array which can grow or shrink its size. Unlike array, we can store n-number of elements in it as there is no size limit. It is a part of Java Collection framework since Java 1.2. It is found in the java.util package and implements the List interface, so we can use all the methods of List interface here.

It is recommended to use the Vector class in the thread-safe implementation only. If you don't need to use the thread-safe implementation, you should use the ArrayList, the ArrayList will perform better in such case.

The Iterators returned by the Vector class are fail-fast. In case of concurrent modification, it fails and throws the ConcurrentModificationException.

It is similar to the ArrayList, but with two differences-
Java Vector contains many legacy methods that are not the part of a collections framework.
Java Vector contains many legacy methods that are not the part of a collections framework
*/


        Vector<String> vec = new Vector<>();
        //Adding elements using add() method of List
        vec.add("Tiger");
        vec.add("Lion");
        vec.add("Dog");
        vec.add("Elephant");

        //Adding elements using addElement() method of Vector
        vec.addElement("Rat");
        vec.addElement("Cat");
        vec.addElement("Deer");

        System.out.println("Elements are: " + vec);


        //Create an empty vector with initial capacity 4
        Vector<String> vec1 = new Vector<String>(4);
        //Adding elements to a vector
        vec1.add("Tiger");
        vec1.add("Lion");
        vec1.add("Dog");
        vec1.add("Elephant");
        //Check size and capacity
        System.out.println("Size is: " + vec1.size());
        System.out.println("Default capacity is: " + vec1.capacity());
        //Display Vector elements
        System.out.println("Vector element is: " + vec1);
        vec1.addElement("Rat");
        vec1.addElement("Cat");
        vec1.addElement("Deer");
        //Again check size and capacity after two insertions
        System.out.println("Size after addition: " + vec1.size());
        System.out.println("Capacity after addition is: " + vec1.capacity());
        //Display Vector elements again
        System.out.println("Elements are: " + vec1);
        //Checking if Tiger is present or not in this vector
        if (vec1.contains("Tiger")) {
            System.out.println("Tiger is present at the index " + vec1.indexOf("Tiger"));
        } else {
            System.out.println("Tiger is not present in the list.");
        }
        //Get the first element
        System.out.println("The first animal of the vector is = " + vec1.firstElement());
        //Get the last element
        System.out.println("The last animal of the vector is = " + vec1.lastElement());


        //Create an empty Vector
        Vector<Integer> in = new Vector<>();
        //Add elements in the vector
        in.add(100);
        in.add(200);
        in.add(300);
        in.add(200);
        in.add(400);
        in.add(500);
        in.add(600);
        in.add(700);
        //Display the vector elements
        System.out.println("Values in vector: " + in);
        //use remove() method to delete the first occurence of an element
        System.out.println("Remove first occourence of element 200: " + in.remove((Integer) 200));
        //Display the vector elements afre remove() method
        System.out.println("Values in vector: " + in);
        //Remove the element at index 4
        System.out.println("Remove element at index 4: " + in.remove(4));
        System.out.println("New Value list in vector: " + in);
        //Remove an element
        in.removeElementAt(5);
        //Checking vector and displays the element
        System.out.println("Vector element after removal: " + in);
        //Get the hashcode for this vector
        System.out.println("Hash code of this vector = " + in.hashCode());
        //Get the element at specified index
        System.out.println("Element at index 1 is = " + in.get(1));

        finalLocalVariable();
    }

    private static void finalLocalVariable(){
        int size = 100;
        String greeting = "Hey";
        Function<Integer,Integer> supplier = x -> x + size;
        supplier.apply(2);
    }
}
