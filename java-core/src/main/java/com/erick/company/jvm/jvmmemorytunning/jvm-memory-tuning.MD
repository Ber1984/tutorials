JVM Memory Tuning
Tuning memory can drastically improve performance.
Common JVM arguments:

Heap Size:

-Xms512m (initial heap size)

-Xmx1024m (maximum heap size)

Young Generation Size:

-Xmn256m (size of young generation)

GC Algorithms:

-XX:+UseG1GC (use G1 GC)

-XX:+UseZGC (use ZGC)

-XX:+UseShenandoahGC (use Shenandoah GC)

GC Logging:

-Xlog:gc* (detailed GC logging)

-XX:+PrintGCDetails (GC details)