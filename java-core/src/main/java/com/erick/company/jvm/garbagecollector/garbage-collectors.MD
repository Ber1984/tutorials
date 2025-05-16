Garbage Collectors in Detail:
1. Serial GC (-XX:+UseSerialGC):
   Single-threaded collector.

Best for single-core systems or small heaps.

Stop-the-world GC (pauses all application threads during collection).

Command
java -XX:+UseSerialGC MyApp

2. Parallel GC (-XX:+UseParallelGC):
Multi-threaded collector.

Focuses on throughput (more application time, less GC time).

Suitable for multi-core systems.

command
java -XX:+UseParallelGC MyApp

3. CMS GC (-XX:+UseConcMarkSweepGC):
   Concurrent Mark-Sweep GC.

Low pause times.

Phases:

Initial Mark

Concurrent Mark

Remark

Sweep

Command
java -XX:+UseConcMarkSweepGC MyApp

4. G1 GC (-XX:+UseG1GC):
   Default in Java 9+.

Divides heap into regions (e.g., 1-32MB).

Prioritizes regions based on garbage first (G1).

command
java -XX:+UseG1GC MyApp

5. ZGC (-XX:+UseZGC):
   Scalable, low-latency collector.

Pause times < 10ms.

Concurrent and compacting.

command
java -XX:+UseZGC MyApp


6. Shenandoah GC (-XX:+UseShenandoahGC):
   Concurrent, low-pause GC.

Suitable for large heaps with predictable latency.

command
java -XX:+UseShenandoahGC MyApp

GC Logging and Monitoring:
java -Xlog:gc*:file=gc.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps MyApp

How to Identify the GC Algorithm?
java -XX:+PrintCommandLineFlags -version

Identifying Memory Leaks:
A memory leak occurs when objects that are no longer needed are not garbage collected.
To detect memory leaks:

Enable GC Logging:
java -Xlog:gc MyApp

2. VisualVM

JProfiler

Eclipse MAT

3. Heap Dump Analysis:

Generate a heap dump:
jmap -dump:live,format=b,file=heapdump.hprof <pid>

Analyze using Eclipse MAT:

Look for objects with high retention size.

GC Tuning:
Common GC Tuning Options:

-Xms: Initial heap size.

-Xmx: Maximum heap size.

-Xmn: Size of the young generation.

-XX:SurvivorRatio: Ratio of Eden to Survivor space.

-XX:MaxGCPauseMillis: Maximum GC pause time.

-XX:G1HeapRegionSize: Size of G1 heap regions.

Example: GC Tuning Command:
java -Xms512m -Xmx2g -XX:MaxGCPauseMillis=200 -XX:+UseG1GC -XX:InitiatingHeapOccupancyPercent=45 MyApp

Summary:
GC in JVM manages memory by reclaiming unused objects, preventing memory leaks, and optimizing heap usage.

Several GC algorithms are available, each with specific use cases (Serial, Parallel, CMS, G1, ZGC, Shenandoah).

GC algorithms can be configured and monitored using JVM flags and profilers.

Effective GC tuning can significantly impact application performance, especially in memory-intensive applications.
