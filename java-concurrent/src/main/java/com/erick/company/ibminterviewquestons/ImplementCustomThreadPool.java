package com.erick.company.ibminterviewquestons;

import java.lang.ref.Cleaner;
import java.util.LinkedList;
import java.util.Queue;

/*
 4. Implement a Custom Thread Pool

 • Demonstrates knowledge of ExecutorService, worker threads, and queue-based task submission.
 */

/*
✅ Explanation:
Task Submission:

Tasks are added to the taskQueue.

Each worker thread waits for a task to be available in the queue.

When a task is added, taskQueue.notify() wakes up a waiting thread to consume the task.

Worker Threads:

Each thread continuously checks the taskQueue for new tasks.

The threads exit gracefully when the isRunning flag is set to false in the shutdown() method.

Shutdown Logic:

The shutdown() method sets isRunning to false and interrupts the thread to exit the wait() state.
 */
public class ImplementCustomThreadPool {
    private final int numberOfThreads;
    private final WorkerThread[] threadPool;
    private final Queue<Runnable> taskQueue;

    public ImplementCustomThreadPool(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
        this.taskQueue = new LinkedList<>();
        this.threadPool = new WorkerThread[numberOfThreads];

        for (int i = 0; i < numberOfThreads; i++) {
            threadPool[i] = new WorkerThread("Thread " + (i + 1));
            threadPool[i].start(); //starting the thread because i need them running and ready to process tasks
        }
    }

    public static void main(String[] args) {
        ImplementCustomThreadPool pool = new ImplementCustomThreadPool(3);

        Runnable task1 = () -> print(Thread.currentThread().getName() + ": Task 1"); //This is my first task
        Runnable task2 = () -> print(Thread.currentThread().getName()+ ": Task 2"); //This is my first task
        Runnable task3 = () -> print(Thread.currentThread().getName()+ ": Task 3"); //This is my first task

        pool.submit(task1);
        pool.submit(task2);
        pool.submit(task3);
    }



    public void submit(Runnable task) {
        synchronized (taskQueue) {
            taskQueue.offer(task); // i have a new task so i need to tell my threads to run it
            taskQueue.notify(); // Notify a waiting thread that a task is available
        }
    }

    private static void print(String message) {
        System.out.println(message);
    }

    private void shutdown() {
        for (WorkerThread thread : threadPool) {
            thread.stopThread();
        }
    }

    private class WorkerThread extends Thread {
        private boolean isRunning = true;

        public WorkerThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (isRunning) {
                Runnable task;
                synchronized (taskQueue) {
                    while (taskQueue.isEmpty()) { //if we don't have task threads are waiting
                        try {
                            taskQueue.wait(); //thread in waiting state
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    task = taskQueue.poll();
                }
                if (task != null) {
                    task.run();
                }
            }
        }

        public void stopThread() {
            isRunning = false;
            this.interrupt(); // Interrupt the waiting state if the thread is waiting
        }
    }
}
