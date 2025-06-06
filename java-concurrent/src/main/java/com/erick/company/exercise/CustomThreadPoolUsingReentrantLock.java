package com.erick.company.exercise;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*
Implement a Custom Thread Pool with ReentrantLock

Create a CustomThreadPool class with a fixed number of worker threads.

Use a ReentrantLock to ensure that only one thread can pick a task from the task queue at a time.

Implement submit(Runnable task) to add tasks to the queue.

Implement a shutdown() method to stop accepting new tasks and allow current tasks to complete.
 */
public class CustomThreadPoolUsingReentrantLock {
    public static void main(String[] args) {
        CustomThreadPool customThreadPool = new CustomThreadPool(2);

        Runnable task = () -> System.out.println("print task 1");
        customThreadPool.submit(task);
        customThreadPool.submit(() -> System.out.println(Thread.currentThread().getName() + "Task 2"));

        customThreadPool.shutDown();
    }

}

class CustomThreadPool {
    private final Worker[] threadPool; //add threads
    private final Queue<Runnable> taskQueue;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition;
    private volatile boolean isShutdown = false;

    public CustomThreadPool(int worker) {
        this.threadPool = new Worker[2];
        this.taskQueue = new LinkedList<>(); //unbounded queue.
        this.condition = lock.newCondition(); //add wait, notify and notify methods for the lock
        for (int i = 0; i < worker; i++) {
            this.threadPool[i] = new Worker(); //instance threads
            this.threadPool[i].start(); //starting threads
        }

    }

    public void submit(Runnable task) {
        //send task by one thread at a time
        lock.lock(); //create the monitor lock
        try {
            taskQueue.offer(task);
            condition.signal(); //like notify method
        } finally {
            lock.unlock();
            /*
             Unlocking the Lock:
             The lock must be unlocked in a finally block to ensure it gets released even if an exception occurs.
             */
        }
    }

    public void shutDown() {
        lock.lock();
        try {
            isShutdown = true;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }


    class Worker extends Thread {
        @Override
        public void run() {
            /*
            The Worker thread should keep running in a loop and continuously check for tasks in the queue.
             */
            while (true) {
                Runnable task = null;
                lock.lock();
                try {
                    while (taskQueue.isEmpty() && !isShutdown) {
                        condition.await(); //like wait()
                    }

                    if(isShutdown && taskQueue.isEmpty()) {
                        break;
                    }
                    //read from queue
                    task = taskQueue.poll();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    lock.unlock();
                }
                if(task != null) {
                    task.run();
                }
            }
        }
    }
}