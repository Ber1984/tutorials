6. Garbage Collection (GC) in JVM
   Garbage Collection (GC) in the JVM is the process of automatically identifying and reclaiming memory that is no longer in use, preventing memory leaks and optimizing memory usage. The JVM uses various GC algorithms to manage heap memory effectively.

📦 Why Garbage Collection?
Memory Management: Reclaims memory from objects that are no longer reachable.

Prevents Memory Leaks: Frees up unused memory to avoid OutOfMemoryError.

Optimizes Performance: Reduces memory footprint and enhances runtime efficiency.

JVM Memory Areas Involved in GC
Heap Memory:

Young Generation (Eden + Survivor 1 + Survivor 2)

Old Generation (Tenured)

Metaspace:

Stores class metadata, method data, and other runtime information.

Replaces PermGen in Java 8 and later.

✅ GC Algorithm Types in JVM
Java provides several GC algorithms, each with its own characteristics:

GC Algorithm	Description	Best for
Serial GC	Single-threaded, stop-the-world GC.	Single-core systems.
Parallel GC	Multi-threaded GC in Young Gen.	Multi-core systems.
CMS GC	Concurrent Mark-Sweep GC.	Low latency applications.
G1 GC	Garbage First, regionalized heap.	Large heaps.
ZGC	Ultra-low pause time, scalable GC.	Large heaps (>= 4GB).
Shenandoah GC	Concurrent and scalable GC.	Real-time systems.

✅ How GC Works - 4 Phases
Marking:

Identifies all live objects that are still reachable.

Normal Deletion/Sweeping:

Reclaims memory occupied by unreachable objects.

Compaction:

Moves live objects together to reduce fragmentation.

Promotion:

Moves objects from the Young Generation to the Old Generation.

✅ Generational Garbage Collection:
Java heap is divided into three regions:

Young Generation:

Divided into Eden, Survivor 1, and Survivor 2.

New objects are allocated in Eden.

Surviving objects move between survivor spaces.

Old Generation:

Objects that survive multiple garbage collection cycles are promoted here.

Major GC (Full GC) occurs here.

Metaspace:

Stores class metadata, method data, and constants.

