package com.erick.company.jvm.reference;

import java.lang.ref.*;
import java.util.WeakHashMap;

/*
1. Strong Reference
A strong reference is the default type of reference in Java.

If an object is referenced by a strong reference, it will not be eligible for garbage collection, even if it is not used anymore.
 */
public class ReferenceType {

    public static void main(String[] args) {

        /*
        1. Strong Reference
A strong reference is the default type of reference in Java.

If an object is referenced by a strong reference, it will not be eligible for garbage collection, even if it is not used anymore.
         The strongRef3 object will never be collected as long as it is accessible.
         */
        String strongRef = new String("Hello, World!");

        /*
        The "Hello, Strong Reference" object is strongly reachable as long as the strongRef variable holds a reference to it.
        Once we set strongRef = null, the object becomes unreachable.

         At this point, it is eligible for garbage collection.
         The JVM will collect it at its own discretion, not immediately after null is assigned.
         */

        /*
      2. Weak Reference
A weak reference allows the referenced object to be garbage collected when the JVM detects that it is weakly reachable.

Ideal for caches, as the object can be reclaimed when memory is low.

Usage:

java.lang.ref.WeakReference
       */

        String strongRef1 = new String("Hello, Weak Reference");
        WeakReference<String> weakRef = new WeakReference<>(strongRef1);

        // Remove the strong reference
        strongRef1 = null;

        // Request GC
        System.gc();

        // Check the reference
        if (weakRef.get() != null) {
            System.out.println("Object is still alive: " + weakRef.get());
        } else {
            System.out.println("Object has been garbage collected");
        }
        /*
        More examples
        Use Case for Weak Reference - Caching
Caches are susceptible to memory leaks if objects are held strongly.

Using a WeakHashMap helps prevent memory leaks by allowing unused cache entries to be collected.

         */

        WeakHashMap<String, String> cache = new WeakHashMap<>();

        String key = new String("key1");
        cache.put(key, "value1");

        System.out.println("Before GC: " + cache);

        key = null; // Remove strong reference
        System.gc(); // Suggest GC

        System.out.println("After GC: " + cache); // Key may be removed

        /*
     3. Soft Reference
A soft reference is similar to a weak reference but with a key difference:

The object will only be collected when memory is low.

Usage:

Suitable for implementing caches where data is important but not critical.
     */
        String strongRef3 = new String("Hello, Soft Reference");
        SoftReference<String> softRef = new SoftReference<>(strongRef3);

        strongRef3 = null; // Remove strong reference

        System.gc(); // Suggest GC

        if (softRef.get() != null) {
            System.out.println("Object is still alive: " + softRef.get());
        } else {
            System.out.println("Object has been garbage collected");
        }

     /*
     SoftReference objects are retained longer than WeakReference objects, making them more suitable for memory-sensitive caches.
      */


       /*
       4. Phantom Reference
A phantom reference is the weakest type of reference.

It only becomes reachable after the object has been finalized but before the memory is reclaimed.

It is used for post-mortem cleanup or resource management.



        */

        ReferenceQueue<String> refQueue = new ReferenceQueue<>();
        String strongRef4 = new String("Hello, Phantom Reference");

        PhantomReference<String> phantomRef = new PhantomReference<>(strongRef4, refQueue);
        strongRef4 = null; // Remove strong reference

        System.gc(); // Suggest GC

        // Check the reference queue
        Reference<?> ref = refQueue.poll();
        if (ref != null) {
            System.out.println("Phantom reference enqueued for cleanup");
        } else {
            System.out.println("Object not yet collected");
        }

        /*
        Phantom references are never accessible via get(), and are only used for cleanup actions.
         */
    }


}
