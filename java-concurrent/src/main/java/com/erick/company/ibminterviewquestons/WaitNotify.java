package com.erick.company.ibminterviewquestons;

import java.util.LinkedList;
import java.util.Queue;

public class WaitNotify {
    private static final Queue<Integer> queue = new LinkedList<>(); //it's not syncronized so i need to add manual syncronization.
    public static void main(String[] args) {
       //create two threads
        Thread producer = new Thread(new Producer());
        Thread consumer = new Thread(new Consumer());



        producer.start();
        consumer.start();
    }

    static class Producer implements Runnable {

        @Override
        public void run() {
            int value = 1;
            synchronized (queue) {
                while (!queue.isEmpty()) { //The producer will block if the queue is full, preventing memory overflow.
                    System.out.println("produced " + value);
                    queue.offer(value++);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    notify();
                }
            }

        }
    }

    static class Consumer implements Runnable {

        @Override
        public void run() {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        wait(); //The consumer will block if the queue is empty, preventing NoSuchElementException.
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                Integer num = queue.poll();
                System.out.println("Consumed " + num);
            }
        }
    }

}
