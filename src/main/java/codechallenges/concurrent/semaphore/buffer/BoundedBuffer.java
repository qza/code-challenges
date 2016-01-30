package codechallenges.concurrent.semaphore.buffer;

import codechallenges.concurrent.semaphore.BinarySemaphore;
import codechallenges.concurrent.semaphore.CountingSemaphore;
import codechallenges.concurrent.semaphore.Semaphore;
import java.lang.reflect.Array;

/**
 * BoundedBuffer
 *
 * Bounded buffer has purpose in Producer-Consumer scenario.
 *
 * Main requirements are:
 *
 * - consumer should not fetch any items when buffer is empty
 *
 * - producers should not depose any items when buffer is full
 *
 * @param <T> type of buffer items
 */
public class BoundedBuffer<T> implements Buffer<T> {
    
    final int size;
    final long DEFAULT_TIMEOUT = 100000L;
    
    final Object buffer;
    final Semaphore mutex, deposeCounter, fetchCounter;
    
    int deposeIndex = 0, fetchIndex = 0;
    
    public <T> BoundedBuffer(Class<T> typeClass, int size) {
        this.size = size;
        this.buffer = Array.newInstance(typeClass, size);
        this.deposeCounter = new CountingSemaphore(size);
        this.fetchCounter = new CountingSemaphore(0);
        this.mutex = new BinarySemaphore();
    }
    
    @Override
    public void depose(T item) {
        deposeCounter.acquire(DEFAULT_TIMEOUT);
        mutex.acquire(DEFAULT_TIMEOUT);
        Array.set(buffer, deposeIndex, item);
        deposeIndex = (deposeIndex + 1) % size;
        mutex.release();
        fetchCounter.release();
    }
    
    @Override
    public T fetch() {
        fetchCounter.acquire(DEFAULT_TIMEOUT);
        mutex.acquire(DEFAULT_TIMEOUT);
        Object element = Array.get(buffer, fetchIndex);
        fetchIndex = (fetchIndex + 1) % size;
        mutex.release();
        deposeCounter.release();
        return (T) element;
    }
    
}
