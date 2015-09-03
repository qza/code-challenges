package codechallenges.conncurency.lock;

/**
 * When process needs to access critical section, it should acquire lock so that
 * no other thread can access the critical section in same moment. When leaving
 * critical section, process should release the lock so that next process can
 * access critical section.
 *
 * This interface is contract for different Lock implementations that enables
 * mutual exclusion for concurrent access.
 */
public interface Lock {

    void acquire(int pid);

    void release(int pid);

}
