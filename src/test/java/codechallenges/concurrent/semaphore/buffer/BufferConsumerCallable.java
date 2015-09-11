package codechallenges.concurrent.semaphore.buffer;

import codechallenges.concurrent.semaphore.buffer.Buffer;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Buffer Consumer Callable
 *
 * Simulates fetching items from the buffer
 *
 */
public class BufferConsumerCallable implements Callable<Integer> {

    private final int threadId;
    private final Buffer<Integer> buffer;
    private final List<Integer> fetchedItems;

    BufferConsumerCallable(int threadId, Buffer<Integer> buffer, List<Integer> fetchedItems) {
        this.threadId = threadId;
        this.buffer = buffer;
        this.fetchedItems = fetchedItems;
    }

    @Override
    public Integer call() throws Exception {
        Integer item = buffer.fetch();
        fetchedItems.add(item);
        System.out.println("consumer" + threadId + " fetched: " + item);
        return item;
    }

}
