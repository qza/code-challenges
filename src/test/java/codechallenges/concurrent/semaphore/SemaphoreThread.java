package codechallenges.concurrent.semaphore;

import codechallenges.concurrent.Concurrent;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * SemaphoreThread
 *
 * Acquires semaphore permission and simulates work inside and outside critical
 * section.
 *
 * Maximum Integer.MAX_VALUE iterations.
 *
 * @author qza
 */
public class SemaphoreThread extends Thread {

    private final int pid;
    private final Semaphore semaphore;
    private final AtomicInteger counter;
    private final Random random = new Random();

    SemaphoreThread(int pid, Semaphore semaphore, AtomicInteger counter) {
        this.pid = pid;
        this.semaphore = semaphore;
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            semaphore.acquire(60 * 1000);
            counter.getAndIncrement();
            System.out.println("in critical: " + pid);
            Concurrent.sleepFor(random.nextInt(500));
            counter.getAndDecrement();
            semaphore.release();
            System.out.println("not in critical: " + pid);
            Concurrent.sleepFor(random.nextInt(500));
        }
    }

}
