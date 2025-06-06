package com.erick.company.jvm.jvmexecution;

public class JVMExecutionProcess {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        int sum = a + b;
        System.out.println("Sum: " + sum);

        /*
        1.Compile the code: javac ExecutionDemo.java
        2.Disassemble the bytecode: javap -c ExecutionDemo.class
          0: iconst_5        // Push int constant 5
  1: istore_1        // Store to local variable 1
  2: bipush 10       // Push byte 10
  4: istore_2        // Store to local variable 2
  5: iload_1         // Load local variable 1
  6: iload_2         // Load local variable 2
  7: iadd            // Add two integers
  8: istore_3        // Store result in variable 3
  9: getstatic       #7 // Field java/lang/System.out:Ljava/io/PrintStream;
 12: iload_3         // Load sum
 13: invokevirtual   #13 // Method println:(I)V
 16: return

         */
    }
}
