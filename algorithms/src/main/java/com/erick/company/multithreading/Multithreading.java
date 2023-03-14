package com.erick.company.multithreading;

import java.util.concurrent.locks.Lock;

public class Multithreading {
    public static void main(String[] args) {

    }
}

class counter {
    private int count = 0;

    /*
     this method  is synchronized so only one thread can access to the resource at at time
     This block makes sure that only one thread can execute the return ++count at a time
     */
    public synchronized int inc() {
        return ++count;
    }

    public int inc2() {
        /*
         other lines of code
         */
        synchronized (this) {
            return ++count;
        }
    }
}

class CounterLock {
    private Lock lock;
    private int count = 0;

    public int inc() {
        lock.lock();
        int newCount = ++count;
        lock.unlock();
        return newCount;
    }
}
