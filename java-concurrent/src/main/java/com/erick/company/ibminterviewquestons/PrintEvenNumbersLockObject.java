package com.erick.company.ibminterviewquestons;

/*
Explanation:
Shared Lock:

A single lock object is used for coordination.

State Control:

A boolean evenTurn is used to determine which thread should print next.

wait() and notify():

Each thread waits until it is its turn to print and then notifies the other thread to continue.

Thread Coordination:

The odd thread prints and then notifies the even thread.

The even thread prints and then notifies the odd thread.
 */
public class PrintEvenNumbersLockObject {

    /*
    In multithreaded programming, we need a mechanism to control access to a shared resource to avoid race conditions and ensure data consistency. This is achieved using a lock object.
     The lock object serves as a monitor for synchronization.

     When a thread enters a synchronized block with lock, it acquires the lock and prevents other threads from entering any other synchronized block that uses the same lock object.
     In the code, both printOddNumbers() and printEvenNumbers() use lock to synchronize their operations, ensuring that only one thread executes the critical section at a time.

     2. Separation of Locking Logic:

Using a separate lock object is considered a best practice because:

It is a clear, specific object dedicated solely for synchronization.

It avoids unintended synchronization on other objects (e.g., this).

Why not synchronize on this?

If you use synchronized (this), you might unintentionally block other synchronized methods in the same class, leading to unexpected behavior and deadlocks.
     */
    private final Object lock = new Object(); //this is my monitor for this specific for coordination - A single lock object is used for coordination.


    private static final int MAX = 100;
    private volatile boolean evenTurn = false;//A boolean evenTurn is used to determine which thread should print next.

    /*
    wait() and notify():

    Each thread waits until it is its turn to print and then notifies the other thread to continue.
     */
    public static void main(String[] args) {
        /*
        Thread Coordination:

The odd thread prints and then notifies the even thread.

The even thread prints and then notifies the odd thread.
         */
        PrintEvenNumbersLockObject printer = new PrintEvenNumbersLockObject();
        Thread t1 = new Thread(() -> printer.printOddNumbers(), "Odd-Thread"); //the task that i'm going to run
        Thread t2 = new Thread(() -> printer.printEvenNumbers(), "Even-Thread");

        t1.start();
        t2.start();
    }

    public void printOddNumbers() {
        for (int i = 1; i <= MAX; i += 2) {
            synchronized (lock) { //using synchronize block using lock to make sure that only one thread can run this critical section.
                while (evenTurn) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " - " + i);
                evenTurn = true;
                lock.notify();
            }
        }
    }

    public void printEvenNumbers() {
        for (int i = 2; i <= MAX; i += 2) {
            synchronized (lock) {
                while (!evenTurn) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " - " + i);
                evenTurn = false;
                lock.notify();
            }
        }
    }
}
