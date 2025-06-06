package com.erick.company.ibminterviewquestons;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;


/*
Explanation:
Initialization:

maxTokens: Maximum tokens the bucket can hold.

refillAmount: Number of tokens added during each refill interval.

refillIntervalMillis: Time interval for refilling tokens.

Token Refill Mechanism:

The startRefillTask() method uses a ScheduledExecutorService to refill tokens at a fixed interval.

This ensures that tokens are added periodically, simulating a rate-limiting mechanism.

Thread Safety:

The tryConsume() method uses a ReentrantLock to ensure atomic access to the shared tokens variable.

Rate Limiting Logic:

If tokens are available, the request is allowed, and a token is consumed.

If no tokens are available, the request is rejected, and a rate limit message is displayed.
 */
public class TokenBucketRateLimiter {

    private final int maxTokens;
    private int tokens;
    private final long refillIntervalMillis;
    private final int refillAmount;
    private final ReentrantLock lock = new ReentrantLock();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public TokenBucketRateLimiter(int maxTokens, int refillAmount, long refillIntervalMillis) {
        this.maxTokens = maxTokens;
        this.tokens = maxTokens;
        this.refillAmount = refillAmount;
        this.refillIntervalMillis = refillIntervalMillis;

        startRefillTask();
    }

    private void startRefillTask() {
        scheduler.scheduleAtFixedRate(() -> {
            lock.lock();
            try {
                if (tokens < maxTokens) {
                    tokens = Math.min(tokens + refillAmount, maxTokens);
                    System.out.println("Refilled tokens: " + tokens);
                }
            } finally {
                lock.unlock();
            }
        }, refillIntervalMillis, refillIntervalMillis, TimeUnit.MILLISECONDS);
    }

    public boolean tryConsume() {
        lock.lock();
        try {
            if (tokens > 0) {
                tokens--;
                System.out.println("Token consumed. Remaining tokens: " + tokens);
                return true;
            } else {
                System.out.println("Rate limit exceeded. No tokens available.");
                return false;
            }
        } finally {
            lock.unlock();
        }
    }

    public void shutdown() {
        scheduler.shutdown();
    }

    public static void main(String[] args) {
        TokenBucketRateLimiter rateLimiter = new TokenBucketRateLimiter(5, 2, 2000);

        // Simulate API requests
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    if (rateLimiter.tryConsume()) {
                        endpoint();
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }).start();
        }
    }

    private static void endpoint() {
        System.out.println(Thread.currentThread().getName() + " - Access granted");
    }

    /*Token Refill Mechanism:
    Concurrency:
    Your implementation is not thread-safe. If multiple threads access the token count simultaneously, race conditions can occur.
    Time-Based Logic:
    The current implementation applies the same logic for every request. Ideally, we should decouple the token decrement logic from the request handling logic.
     */

}
