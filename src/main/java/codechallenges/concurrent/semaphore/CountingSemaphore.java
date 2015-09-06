package codechallenges.concurrent.semaphore;

/**
 * CountingSemaphore
 *
 * Allows multiple concurrent access to critical section. Applies basic Java
 * synchronization primitives.
 *
 * @see Semaphore
 */
public class CountingSemaphore implements Semaphore {

    private int permissions;

    public CountingSemaphore(int permissions) {
        this.permissions = permissions > 0 ? permissions : 1;
    }

    @Override
    public synchronized void acquire(long timeout) {
        permissions--;
        if (permissions <= 0) {
            try {
                wait(timeout);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @Override
    public synchronized void release() {
        permissions++;
        notify();
    }

}
