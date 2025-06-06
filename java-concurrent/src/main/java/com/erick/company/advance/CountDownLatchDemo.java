package com.erick.company.advance;

import java.util.concurrent.CountDownLatch;

/*
You are close, but let's clarify the distinction:

CountDownLatch:

Allows one or more threads to wait for a set of other threads to complete before proceeding.

Once the latch count reaches zero, the waiting threads can proceed.

Use Case: Wait for multiple tasks to complete before proceeding.
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);

        new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("Task 1 done");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                latch.countDown();
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Task 2 done");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                latch.countDown();
            }
        }).start();

        try {
            latch.await();  // Wait for all tasks to complete
            System.out.println("All tasks finished, proceeding...");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    /*
    Once all three countDown() calls are made, the main thread proceeds.
     */

    /*
     Is CountDownLatch similar to Spring Boot's initialization process?
Great analogy. Yes, you are on the right track.

In Spring Boot, the application context initializes all beans and dependencies before starting the main application logic.

You could think of it as having multiple threads that are initializing beans, and once they are done, the main application starts.

Here’s a simplified analogy using CountDownLatch:

     */
    private static final CountDownLatch latch = new CountDownLatch(3);
    public static void SpringBootStartupSimulation () throws InterruptedException {

        new Thread(() -> {
            System.out.println("Initializing Database Connection...");
            latch.countDown();
        }).start();

        new Thread(() -> {
            System.out.println("Initializing Service Layer...");
            latch.countDown();
        }).start();

        new Thread(() -> {
            System.out.println("Initializing Repositories...");
            latch.countDown();
        }).start();

        /*
        The main thread waits until all initialization threads complete their tasks (countDown()).

Once the latch reaches zero, the application is considered ready to run.
         */
        latch.await();  // Wait for all initializations to complete
        System.out.println("All components initialized. Application is ready to run.");
    }


}
