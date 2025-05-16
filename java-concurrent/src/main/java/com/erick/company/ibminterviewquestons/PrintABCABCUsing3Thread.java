package com.erick.company.ibminterviewquestons;

/*
 3. Print “ABCABC…” using 3 Threads

 • Each thread prints one character in strict sequence.

 • Tests your understanding of low-level locks or advanced coordination (e.g., ReentrantLock, Condition, CyclicBarrier).
 */

/*
 Explanation:
Thread Identification:

Thread A is responsible for printing A and checks (pos % 3 == 0).

Thread B is responsible for printing B and checks (pos % 3 == 1).

Thread C is responsible for printing C and checks (pos % 3 == 2).

Synchronization:

The lock object is used to control access to the shared variable pos.

Each thread checks if it is its turn to print based on the remainder of pos % 3.

Termination:

Each thread prints its letter MAX_COUNT times, resulting in a total output of "ABCABC...ABC".
 */
public class PrintABCABCUsing3Thread {
    private static int pos = 0;
    private static final int MAX_COUNT = 10; // Number of cycles of ABC
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> print('A', 0), "Thread A"); //Thread A is responsible for printing A and checks (pos % 3 == 0).
        Thread threadB = new Thread(() -> print('B', 1), "Thread B"); //Thread B is responsible for printing B and checks (pos % 3 == 1).
        Thread threadC = new Thread(() -> print('C', 2), "Thread C"); //Thread C is responsible for printing C and checks (pos % 3 == 2).

        threadA.start();
        threadB.start();
        threadC.start();
    }

    private static void print(char letter, int threadPosition) {
        synchronized (lock) { //The lock object is used to control access to the shared variable pos.
            System.out.println("Current Thread " + Thread.currentThread().getName());
            for (int i = 0; i < MAX_COUNT; i++) {
                while (pos % 3 != threadPosition) { //Each thread checks if it is its turn to print based on the remainder of pos % 3
                    System.out.println("Current Thread " + Thread.currentThread().getName());
                    try {
                        lock.wait();
                        System.out.println("Current Thread " + Thread.currentThread().getName() + " State " + Thread.currentThread().getState());
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println("Letter " + letter + " Current thread " + Thread.currentThread().getName());
                pos++;
                lock.notifyAll(); //notify all remaining thread - Once the current thread prints its assigned character, it increments pos and calls lock.notifyAll() to wake up all waiting threads.
            }
        }
    }
}
