package codechallenges.concurrent.semaphore;

/**
 * BoundedBuffer
 *
 * Bounded buffer has purpose in Produces-Consumer scenario.
 *
 * Main requirements are:
 *
 * - consumer should not fetch any items when buffer is empty
 *
 * - produces should not depose any items when buffer is full
 *
 */
public class BoundedBuffer implements Buffer<String> {
    
    final int size;
    final long DEFAULT_TIMEOUT = 10000L;
    
    final String[] buffer;
    final Semaphore mutex, deposeCounter, fetchCounter;
    
    int deposeIndex = 0, fetchIndex = 0;
    
    public BoundedBuffer(int size) {
        this.size = size;
        this.buffer = new String[size];
        this.deposeCounter = new CountingSemaphore(size);
        this.fetchCounter = new CountingSemaphore(0);
        this.mutex = new BinarySemaphore();
    }
    
    @Override
    public void depose(String item) {
        deposeCounter.acquire(DEFAULT_TIMEOUT);
        mutex.acquire(DEFAULT_TIMEOUT);
        buffer[deposeIndex] = item;
        deposeIndex = (deposeIndex + 1) % size;
        mutex.release();
        fetchCounter.release();
    }
    
    @Override
    public String fetch() {
        deposeCounter.release();
        mutex.acquire(DEFAULT_TIMEOUT);
        String element = buffer[fetchIndex];
        fetchIndex = (fetchIndex + 1) % size;
        mutex.release();
        deposeCounter.release();
        return element;
    }
    
}
