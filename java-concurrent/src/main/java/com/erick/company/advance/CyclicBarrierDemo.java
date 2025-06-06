package com.erick.company.advance;

import java.util.concurrent.CyclicBarrier;

/*
CyclicBarrier:

Allows a set of threads to wait for each other at a common barrier point.

Once all participating threads reach the barrier, they are released together.

Use Case: Perform a specific task once all threads reach a common point.
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            System.out.println("All threads reached the barrier, proceeding...");
        });

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " reached the barrier");
                    barrier.await();  // Wait for all threads to reach the barrier
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        }
    }
}
