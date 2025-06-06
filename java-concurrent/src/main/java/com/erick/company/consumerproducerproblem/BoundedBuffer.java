package com.erick.company.consumerproducerproblem;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*
A bounded buffer is a fixed-size data structure that is used to store a limited number of items. It is commonly used in scenarios like the Producer-Consumer problem, where producers add items to the buffer and consumers remove items from it.

✅ Characteristics of a Bounded Buffer:
Fixed Capacity: The size of the buffer is predefined and cannot grow dynamically.

Blocking Behavior: If the buffer is full, producers must wait until space becomes available. If the buffer is empty, consumers must wait until an item is available.

Thread Safety: Access to the buffer is synchronized to prevent data corruption due to concurrent access
 */
public class BoundedBuffer {
    private static final int BUFFER_CAPACITY = 3;
    private static final BlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(BUFFER_CAPACITY);

    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    System.out.println("Producing: " + i);
                    buffer.put(i);  // Blocks if buffer is full
                    System.out.println("Buffer size after producing: " + buffer.size());
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    Integer item = buffer.take();  // Blocks if buffer is empty
                    System.out.println("Consuming: " + item);
                    System.out.println("Buffer size after consuming: " + buffer.size());
                    Thread.sleep(1500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}
