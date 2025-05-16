package com.erick.company.ibminterviewquestons;



public class PrintEvenAndOddNumberByThread {
    private static final int MAX = 100;
    private boolean isOdd = true;
    public static void main(String[] args) {
        printSequenceMain();
    }

    /*
 2. Print 1 to 100 in Sequence using Multiple Threads

 • Thread A prints odd, Thread B prints even.
 • Focus: Thread coordination, synchronized, volatile, or Lock.
 */
    private static void printSequenceMain() {
        //i need to create 2 threads
        PrintEvenAndOddNumberByThread printer = new PrintEvenAndOddNumberByThread();
        Thread threadA = new Thread(() -> printer.printOdd());
        Thread threadB = new Thread(() -> printer.printEven());

        threadA.start();
        threadB.start();
    }

    public synchronized void printOdd() {
        for (int i = 1; i <= MAX; i += 2) {
            while (!isOdd) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Thread A (Odd): " + i);
            isOdd = false;
            notify();
        }
    }

    public synchronized void printEven() {
        for (int i = 2; i <= MAX; i += 2) {
            while (isOdd) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Thread B (Even): " + i);
            isOdd = true;
            notify();
        }
    }
}
