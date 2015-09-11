package codechallenges.concurrent.semaphore.rw;

import codechallenges.concurrent.semaphore.BinarySemaphore;
import java.util.HashMap;
import java.util.Map;

/**
 * Basic Database connection implementation.
 *
 * Implements protocol for shared database access with multiple writers and
 * readers.
 *
 * Basic protocol characteristics:
 *
 * - multiple readers can read the values from the database in the same moment
 *
 * - only single writer can write value into the database in one moment
 *
 * - only one reader or writer can access database in one moment
 *
 * @see ReadWriteResource
 */
public class DatabaseConnection implements ReadWriteResource<String> {

    final Long DEFAULT_TIMEOUT = 10000L;

    Map<Long, String> data = new HashMap<>();

    BinarySemaphore writes = new BinarySemaphore();

    BinarySemaphore readWrites = new BinarySemaphore();

    @Override
    public void write(Long index, String value) {
        writes.acquire(DEFAULT_TIMEOUT);
        readWrites.acquire(DEFAULT_TIMEOUT);
        data.put(index, value);
        readWrites.release();
        writes.release();
    }

    @Override
    public String read(Long index) {
        readWrites.acquire(DEFAULT_TIMEOUT);
        String item = data.get(index);
        readWrites.release();
        return item;
    }

}
