package com.erick.company.collections;

import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        /*
        1. Adding Elements: In order to add an element to the stack, we can use the push() method. This push() operation place the element at the top of the stack.
         */
        Stack<String> stack1 = new Stack<String>();

        // pushing the elements

        stack1.push("All");
        stack1.push("Geeks");

        stack1.push("Geeks");
        stack1.push("For");
        stack1.push("Geeks");

        // Printing the Stack Elements
        System.out.println(stack1);
        System.out.println(stack1);

        // Creating an empty Stack
        Stack<Integer> stack2 = new Stack<Integer>();

        // Use add() method to add elements
        stack2.push(10);
        stack2.push(15);
        stack2.push(30);
        stack2.push(20);
        stack2.push(5);

        // Displaying the Stack
        System.out.println("Initial Stack: " + stack2);

        // Removing elements using pop() method
        System.out.println("Popped element: "
                + stack2.pop());
        System.out.println("Popped element: "
                + stack2.pop());

        // Displaying the Stack after pop operation
        System.out.println("Stack after pop operation "
                + stack2);

        Stack<Integer> stack23 = new Stack<Integer>();
        stack23.pop();
    }


}
