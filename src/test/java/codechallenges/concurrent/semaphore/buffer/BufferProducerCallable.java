package codechallenges.concurrent.semaphore.buffer;

import codechallenges.concurrent.semaphore.buffer.Buffer;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Buffer Producer Thread
 *
 * Simulates deposing items into the buffer
 *
 */
public class BufferProducerCallable implements Callable<Integer> {

    private final int threadId;
    private final Buffer<Integer> buffer;
    private final AtomicInteger counter;

    BufferProducerCallable(int threadId, Buffer<Integer> buffer, AtomicInteger counter) {
        this.threadId = threadId;
        this.buffer = buffer;
        this.counter = counter;
    }

    @Override
    public Integer call() throws Exception {
        Integer item = counter.getAndIncrement();
        buffer.depose(item);
        System.out.println("producer" + threadId + " deposed: " + item);
        return null;
    }

}
