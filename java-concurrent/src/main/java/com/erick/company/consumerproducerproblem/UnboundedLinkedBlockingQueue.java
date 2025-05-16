package com.erick.company.consumerproducerproblem;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/*
In Java, an unbounded buffer can be implemented using a LinkedBlockingQueue.

LinkedBlockingQueue is a blocking queue based on linked nodes.

It can be either bounded or unbounded.

If no capacity is specified during its creation, it will use Integer.MAX_VALUE as its capacity, effectively making it unbounded.
 */
public class UnboundedLinkedBlockingQueue {

    private static final BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            int value = 1;
            try {
                while (true) {
                    System.out.println("Producing: " + value);
                    queue.put(value);  // Will not block since the queue is effectively unbounded
                    value++;
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    Integer item = queue.take();  // Will block if the queue is empty
                    System.out.println("Consuming: " + item);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }

    /*
     Explanation:
Here, the LinkedBlockingQueue is created without a capacity, making it unbounded.

Since the queue is unbounded, the producer can continue adding items indefinitely without being blocked by capacity restrictions.

However, it will still block if the consumer is too slow to process the items, causing memory to grow as items accumulate.

✅ Potential Risks of Unbounded Buffers:
Memory Overflow: Since the queue can grow without limit, excessive production without sufficient consumption can lead to OutOfMemoryError.

Backpressure Handling: In real-world scenarios, unbounded queues should be avoided or limited using monitoring and backpressure mechanisms to prevent resource exhaustion.

Would you like me to demonstrate how to convert it to a bounded queue to prevent uncontrolled growth?

    Why Integer.MAX_VALUE?
Integer.MAX_VALUE is 2^31 - 1, which is 2147483647.

This is considered unbounded for practical purposes, but technically, it is still a finite limit.

If the queue grows to this size, it will eventually throw an OutOfMemoryError due to lack of heap space.

 Important Considerations:
If you try to add Integer.MAX_VALUE elements, the program will likely run out of heap memory long before reaching the limit.

Thus, in practice, even "unbounded" queues are limited by the available memory.

     */

    public static void unboundedQueueExample () {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

        System.out.println("Queue capacity: " + Integer.MAX_VALUE);

        try {
            // Attempt to add MAX_VALUE elements (not practical, just for illustration)
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                queue.put(i);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (OutOfMemoryError e) {
            System.out.println("OutOfMemoryError: Queue exceeded available memory");
        }
    }
}
