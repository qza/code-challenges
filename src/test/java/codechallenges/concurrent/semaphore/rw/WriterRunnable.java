package codechallenges.concurrent.semaphore.rw;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Writer Thread
 *
 * Simulates writing values into {@link ReadWriteResource}
 */
public class WriterRunnable extends Thread {

    private final int threadId;
    private final ReadWriteResource<String> rwResouce;
    private final AtomicLong counter;

    WriterRunnable(int threadId, ReadWriteResource<String> rwResouce, AtomicLong counter) {
        this.threadId = threadId;
        this.rwResouce = rwResouce;
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            Long index = counter.getAndIncrement();
            String item = "item_" + index;
            rwResouce.write(index, item);
            System.out.println("writer " + threadId + " wrote: " + item);
        }
    }

}
