package codechallenges.concurrent.semaphore.rw;

import codechallenges.concurrent.semaphore.BinarySemaphore;

/**
 * Basic Database protocol implementation.
 *
 * Implements protocol for shared database access with multiple writers and
 * readers.
 *
 * Basic characteristics:
 *
 * - multiple readers can read the values from the database in the same moment
 *
 * - only single writer can write value into the database in one moment
 *
 * - only one reader or writer can access database in one moment
 *
 * @see ReadWriteProtocol
 */
public class DatabaseProtocol implements ReadWriteProtocol {

    final Long DEFAULT_TIMEOUT = 10000L;

    volatile int readersCount = 0;

    BinarySemaphore writes = new BinarySemaphore();

    BinarySemaphore mutex = new BinarySemaphore();

    @Override
    public void startWrite() {
        writes.acquire(DEFAULT_TIMEOUT);
    }

    @Override
    public void endWrite() {
        writes.release();
    }

    @Override
    public void startRead() {
        mutex.acquire(DEFAULT_TIMEOUT);
        readersCount += 1;
        if (readersCount == 1) {
            writes.acquire(DEFAULT_TIMEOUT);
        }
        mutex.release();
    }

    @Override
    public void endRead() {
        mutex.acquire(DEFAULT_TIMEOUT);
        readersCount -= 1;
        if (readersCount == 0) {
            writes.release();
        }
        mutex.release();
    }

}
