package com.erick.company.consumerproducerproblem;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*
✅ Explanation:
BlockingQueue Implementation:

We use ArrayBlockingQueue with a fixed capacity of 5.

If the queue is full, the put() method will block until space becomes available.

If the queue is empty, the take() method will block until an item is available.

Producer:

Produces integers and puts them into the queue using put().

If the queue is full, it waits until space is available.

Consumer:

Consumes integers from the queue using take().

If the queue is empty, it waits until an item is available.

✅ Advantages of BlockingQueue:
Eliminates the need for explicit synchronization (wait()/notify()).

Provides thread-safe operations with built-in blocking behavior.

Simplifies the code and reduces the risk of concurrency bugs.
 */
public class ConsumerProducerBlockingQueue {
    private static final int QUEUE_CAPACITY = 5;
    private static final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);

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
            try {
                while (true) {
                    System.out.println("Produced: " + value);
                    queue.put(value);  // This will block if the queue is full
                    value++;
                    Thread.sleep(1000);  // Simulate production delay
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    static class Consumer implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    Integer value = queue.take();  // This will block if the queue is empty
                    System.out.println("Consumed: " + value);
                    Thread.sleep(1500);  // Simulate consumption delay
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
