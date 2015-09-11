package codechallenges.concurrent.semaphore;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Writer Thread
 *
 * Simulates writing values into {@link ReadWriteResource}
 */
public class ReaderThread extends Thread {

    private final int threadId;
    private final ReadWriteResource<String> rwResouce;
    private final AtomicInteger counter;

    ReaderThread(int threadId, ReadWriteResource<String> rwResouce, AtomicInteger counter) {
        this.threadId = threadId;
        this.rwResouce = rwResouce;
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String item = rwResouce.read();
            counter.getAndIncrement();
            System.out.println("reader " + threadId + " read: " + item);
        }
    }

}
