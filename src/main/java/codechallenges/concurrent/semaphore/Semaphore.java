package codechallenges.concurrent.semaphore;

/**
 * Semaphore interface
 */
public interface Semaphore {

    void acquire(long timeout);

    void release();

}
