package codechallenges.concurrent.semaphore;

import codechallenges.concurrent.Concurrent;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Buffer Consumer Thread
 * 
 * Simulates fetching items from the buffer
 * 
 */
public class BufferConsumerThread  extends Thread {

    private final int threadId;
    private final Buffer<String> buffer;
    private final AtomicInteger counter;
    private final Random random = new Random();

    BufferConsumerThread(int threadId, Buffer<String> buffer, AtomicInteger counter) {
        this.threadId = threadId;
        this.buffer = buffer;
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String item = buffer.fetch();
            System.out.println(threadId + " fetched: " + item);
            counter.getAndDecrement();
            Concurrent.sleepFor(random.nextInt(500));
        }
    }

}
