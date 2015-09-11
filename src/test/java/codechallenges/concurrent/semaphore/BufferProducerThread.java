package codechallenges.concurrent.semaphore;

import codechallenges.concurrent.Concurrent;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Buffer Producer Thread
 *
 * Simulates deposing items into the buffer
 *
 */
public class BufferProducerThread extends Thread {

    private final int threadId;
    private final Buffer<String> buffer;
    private final AtomicInteger counter;
    private final Random random = new Random();

    BufferProducerThread(int threadId, Buffer<String> buffer, AtomicInteger counter) {
        this.threadId = threadId;
        this.buffer = buffer;
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String item = "item_" + i;
            buffer.depose(item);
            counter.getAndIncrement();
            System.out.println(threadId + " deposed: " + item);
            Concurrent.sleepFor(random.nextInt(500));
            counter.getAndDecrement();
        }
    }

}
