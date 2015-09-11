package codechallenges.concurrent.semaphore.buffer;

/**
 * Buffer interface
 *
 * Basic contract for buffer structure that allows deposing and fetching items
 *
 * @param <T> Type of buffer item
 */
public interface Buffer<T> {

    void depose(T item);

    T fetch();
}
