package dev.danvega.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceNewFixedThreadPool {
    public static void main(String[] args) throws InterruptedException {
        int threadNum = Integer.parseInt(args[0]);
        ExecutorService executorService = Executors.newFixedThreadPool(threadNum);

        for (int j = 0; j < 20000; j++) {
            executorService.execute(new Thread(() -> {
                //Do something
            }));
        }
        executorService.shutdown(); //prevents clients to send more work to the executor service.
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
    }
}
