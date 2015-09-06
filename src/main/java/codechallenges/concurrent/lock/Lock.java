package codechallenges.concurrent.lock;

/**
 * Lock
 *
 * This interface is contract for different Lock implementations that enables
 * mutual exclusion for concurrent access.
 *
 * When process needs to access critical section, it should acquire lock so that
 * no other thread can access the critical section in same moment. When leaving
 * critical section, process should release the lock so that next process can
 * access critical section.
 *
 * @see PetersonLock
 * @see LamportBakeryLock
 */
public interface Lock {

    void acquire(int pid);

    void release(int pid);

}
