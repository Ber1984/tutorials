package com.erick.company.jvm.bytecode;

/*
Compile the class:
javac BytecodeExample.java

View bytecode using javap:
javap -c -v BytecodeExample.class


Partial output
Method displayMessage()V
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=2, locals=2, args_size=1
         0: ldc           #8                  // String Hello, Bytecode!
         2: astore_1
         3: getstatic     #10                 // Field java/lang/System.out:Ljava/io/PrintStream;
         6: aload_1
         7: invokevirtual #16                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        10: return


 */
public class BytecodeExample {
    public void displayMessage() {
        String message = "Hello, Bytecode!";
        System.out.println(message);
    }
}
