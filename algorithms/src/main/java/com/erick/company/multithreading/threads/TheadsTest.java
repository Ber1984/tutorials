package com.erick.company.multithreading.threads;

public class TheadsTest {

    public static void main(String[] args) {
        System.out.printf("name given by JVM" + Thread.currentThread().getName());
        Thread thread = new Thread("My new Thread");
        thread.start();

        try {
            Thread.sleep(3L * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> System.out.println("Thread: " + finalI + "running")).start();
        }

        System.out.println(thread.getName());

        MyThread m = new MyThread();
        m.start();

        // anonymous subclass of Thread
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                super.run();
            }
        };

        /*
        Whatever the thread is supposed to do when it executes must be included in the implementation of the run() method.
        There are three ways to implement the Runnable interface:

        Create a Java class that implements the Runnable interface.
        Create an anonymous class that implements the Runnable interface.
        Create a Java Lambda that implements the Runnable interface.
         */

        Runnable runnable = () -> System.out.println("My thread in a lambda expression ");
        runnable.run();


        /*
           Starting a Thread With a Runnable
        */
        Runnable runnable3 = new MyRunnable(); // or an anonymous class, or lambda...

        Thread thread3 = new Thread(runnable3);
        thread3.start();

        /*
         stop a thread

         */

    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread running");
    }
}

class MyRunnable implements Runnable {
    private boolean doStop = false;

    public synchronized void doStop() {
        this.doStop = true;
    }

    private synchronized boolean keepRunning() {
        return this.doStop == false;
    }

    @Override
    public void run() {
        while (keepRunning()) {
            System.out.println("Running");
            try {
                Thread.sleep(3l * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //System.out.println("MyRunnable running");
    }


    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            System.out.println("MyRunnable running");
        }
    };

    Runnable runnable2 =
            () -> {
                System.out.println("Lambda Runnable running");
            };

}
