package com.erick.company.ibminterviewquestons;

public class DeadLock {

    private static final Object resource1 = new Object(); //resource to read
    private static final Object resource2 = new Object();

    public static void main(String[] args) {

        Thread threadA = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread A: Locked resource1");

                try { Thread.sleep(100); } catch (InterruptedException e) {}

                System.out.println("Thread A: Waiting to lock resource2");
                synchronized (resource2) {
                    System.out.println("Thread A: Locked resource2");
                }
            }
        });

        Thread threadB = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread B: Locked resource2");

                try { Thread.sleep(100); } catch (InterruptedException e) {}

                System.out.println("Thread B: Waiting to lock resource1");
                synchronized (resource1) {
                    System.out.println("Thread B: Locked resource1");
                }
            }
        });

        threadA.start();
        threadB.start();
    }

    /*
    Thread A locks resource1 and waits for resource2.

Thread B locks resource2 and waits for resource1.

Both threads are waiting indefinitely, causing a deadlock.
     */


    /*
    How to Avoid Deadlock:
    Resource Ordering:

Always acquire resources in the same order. This prevents circular waiting.

synchronized (resource1) {
    synchronized (resource2) {
        // Work with both resources
    }
}

Try-Lock with Timeout:

Use tryLock() with a timeout to avoid indefinite waiting.

ReentrantLock lock1 = new ReentrantLock();
ReentrantLock lock2 = new ReentrantLock();

try {
    if (lock1.tryLock(1, TimeUnit.SECONDS)) {
        if (lock2.tryLock(1, TimeUnit.SECONDS)) {
            // Critical section
        } else {
            lock1.unlock();
        }
    }
} catch (InterruptedException e) {
    e.printStackTrace();
}

Deadlock Detection:

Implement logic to detect and handle deadlocks. Java provides tools like ThreadMXBean for detecting deadlocks.

Avoid Nested Locks:

Minimize the number of locks held simultaneously.

   */
}
