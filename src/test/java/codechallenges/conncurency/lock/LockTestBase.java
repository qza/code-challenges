package codechallenges.conncurency.lock;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Base class for Lock tests
 */
public abstract class LockTestBase {

    class CriticalSectionThread extends Thread {

        int pid;
        Lock lock;
        AtomicInteger counter;

        Random random = new Random();

        CriticalSectionThread(int pid, Lock lock, AtomicInteger counter) {
            this.pid = pid;
            this.lock = lock;
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i < Integer.MAX_VALUE / 2; i++) {
                lock.acquire(pid);
                counter.getAndIncrement();
                System.out.println("in critical: " + pid);
                waitfor(random.nextInt(500));
                counter.getAndDecrement();
                lock.release(pid);
                System.out.println("not in critical: " + pid);
                waitfor(random.nextInt(500));
            }
        }

    }

    class CheckThread extends Thread {

        int checksCount;
        int[] results;

        final AtomicInteger counter;

        public CheckThread(int checksCount, AtomicInteger counter) {
            this.checksCount = checksCount;
            this.results = new int[checksCount];
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i < checksCount; i++) {
//                System.out.println("\t\t\t [count: " + counter + "]");
                results[i] = counter.intValue();
                waitfor(100);
            }
        }
    }

    protected static void waitfor(int miliseconds) {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }

}
