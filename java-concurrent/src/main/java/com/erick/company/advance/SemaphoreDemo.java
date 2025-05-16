package com.erick.company.advance;

import java.util.concurrent.Semaphore;

/*
A Semaphore is a concurrency control mechanism that controls access to a shared resource through a set number of permits.

It maintains a counter (permits) that indicates the number of threads that can access the resource simultaneously.

When a thread acquires a permit, the count is decremented.

When a thread releases a permit, the count is incremented.
 */
public class SemaphoreDemo {

    private static final Semaphore semaphore = new Semaphore(2); // 2 permits

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " trying to acquire...");
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " acquired the permit.");
                    Thread.sleep(2000); // Simulate work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName() + " released the permit.");
                }
            }).start();
        }
    }
    //Only two threads can acquire a permit at a time because the semaphore was initialized with 2 permits
}
