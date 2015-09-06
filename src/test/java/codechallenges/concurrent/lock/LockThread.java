package codechallenges.concurrent.lock;

import codechallenges.concurrent.Concurrent;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * LockThread
 *
 * Acquires lock for given PID and simulates work inside and outside critical
 * section.
 *
 * Maximum Integer.MAX_VALUE iterations.
 *
 * @author qza
 */
public class LockThread extends Thread {

    private final int pid;
    private final Lock lock;
    private final AtomicInteger counter;
    private final Random random = new Random();

    LockThread(int pid, Lock lock, AtomicInteger counter) {
        this.pid = pid;
        this.lock = lock;
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            lock.acquire(pid);
            counter.getAndIncrement();
            System.out.println("in critical: " + pid);
            Concurrent.waitfor(random.nextInt(500));
            counter.getAndDecrement();
            lock.release(pid);
            System.out.println("not in critical: " + pid);
            Concurrent.waitfor(random.nextInt(500));
        }
    }

}
