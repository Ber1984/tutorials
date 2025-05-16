          +-----------------------------------+
          |         Class Loader Subsystem     |
          +-----------------------------------+
                           |
                           v
          +-----------------------------------+
          |           Runtime Data Area       |
          +-----------------------------------+
          | Method Area     | Heap            |
          | Stack           | Native Method   |
          | PC Register     |                 |
          +-----------------------------------+
                           |
                           v
          +-----------------------------------+
          |          Execution Engine         |
          +-----------------------------------+
          | Interpreter  | JIT Compiler      |
          | Garbage Collector                 |
          +-----------------------------------+
                           |
                           v
          +-----------------------------------+
          |     Native Method Interface       |
          +-----------------------------------+
                           |
                           v
          +-----------------------------------+
          |      Native Method Libraries      |
          +-----------------------------------+

Main Components and Their Roles
Class Loader Subsystem

Responsible for loading, linking, and initializing classes.

It follows the Delegation Model, where classes are loaded in the following order:

Bootstrap Class Loader (loads core Java libraries, rt.jar)

Extension Class Loader (loads extension libraries, lib/ext)

Application Class Loader (loads classes from the classpath)

Key Methods:

loadClass(String name)

findClass(String name)

defineClass(String name, byte[] b, int off, int len)

Runtime Data Areas

Divided into several regions:

Method Area:

Stores class-level information: class structure, fields, methods, constant pool.

Shared among all threads.

In Java 8 and earlier, it was called PermGen.

In Java 8+, it was replaced by Metaspace, which is dynamically sized.

Heap:

Stores objects and instance variables.

Managed by the Garbage Collector.

Divided into:

Young Generation (Eden + S1 + S2)

Old Generation

Permanent Generation (Java 7 and below) / Metaspace (Java 8+)

Java Stack:

Stores frames for each method invocation.

Each frame contains:

Local variables

Operand stack

Return address

PC (Program Counter) Register:

Stores the address of the currently executing JVM instruction.

Each thread has its own PC register.

Native Method Stack:

Stores native method calls (methods written in C/C++).

Execution Engine

Converts bytecode into machine code for execution.

Contains:

Interpreter:

Reads and executes bytecode line-by-line.

Slower due to repetitive parsing.

Just-In-Time (JIT) Compiler:

Converts bytecode into native machine code.

Optimizes frequently executed code paths (hotspots).

Garbage Collector:

Reclaims memory used by unreachable objects.

Multiple GC algorithms:

Serial GC, Parallel GC, CMS, G1, ZGC, Shenandoah.

Native Method Interface (JNI)

Allows Java code to call native methods written in C/C++.

Critical for integrating Java with existing C/C++ libraries or performing low-level operations.

Native Method Libraries

Dynamic libraries (.dll on Windows, .so on Linux) that are loaded at runtime.

🔥 3. Key Takeaways
Class Loader: Loads classes dynamically at runtime.

Runtime Data Areas: Organizes memory into specific regions for efficient management.

Execution Engine: Executes bytecode using the interpreter and JIT compiler.

JNI: Connects Java with native code.

Native Libraries: Provide low-level system integration.
