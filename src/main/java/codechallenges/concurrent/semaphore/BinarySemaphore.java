package codechallenges.concurrent.semaphore;

/**
 * Binary semaphore
 *
 * Enables mutual exclusion and single access to critical section. Applies basic
 * Java synchronization primitives.
 *
 * Methods for acquiring and releasing permission are synchronized so that
 * happens-before relation is defined. When thread needs to acquire permission,
 * it gets lock on instance of the semaphore. If Permission is already acquired,
 * thread is placed in waiting set of threads {@link java.lang.Object#wait()}.
 * When releasing permission, thread notifies all waiting threads that are then
 * awaken from the waiting set {@link java.lang.Object#notifyAll()}
 *
 */
public class BinarySemaphore implements Semaphore {

    boolean alreadyAcquired = true;

    @Override
    public synchronized void acquire(long timeout) {
        while (!alreadyAcquired) {
            try {
                wait(timeout);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
        alreadyAcquired = false;
    }

    @Override
    public synchronized void release() {
        alreadyAcquired = true;
        notifyAll();
    }

}
