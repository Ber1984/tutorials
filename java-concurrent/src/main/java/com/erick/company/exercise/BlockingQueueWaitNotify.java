package com.erick.company.exercise;

import java.util.LinkedList;
import java.util.Queue;

/*
Exercise 9: Implement a BlockingQueue Using Wait-Notify
Implement a CustomBlockingQueue that can hold a fixed number of tasks.

Use wait() and notifyAll() to handle producers and consumers.

Ensure that producers block when the queue is full and consumers block when the queue is empty.
 */
public class BlockingQueueWaitNotify {
    private static final Queue<Integer> queueTask = new LinkedList<>();
    private static final int CAPACITY = 5;
    public static void main(String[] args) {

        Thread producer = new Thread(new Producer());
        Thread consumer = new Thread(new Consumer());

        producer.start();
        consumer.start();
    }


    static class Producer implements Runnable {

        @Override
        public void run() {
            int value = 1;
            while (true) {
                synchronized (queueTask) {
                    while (queueTask.size() == CAPACITY) {
                        try {
                            queueTask.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println("Produced: " + value);
                    queueTask.offer(value++);
                    queueTask.notify();
                }
            }
        }
    }


    static class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (queueTask) {
                    while (queueTask.isEmpty()) {
                        try {
                            queueTask.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }

                    int task = queueTask.poll();
                    System.out.println("Consumed: " + task);
                    queueTask.notify();
                }
            }
        }
    }
}