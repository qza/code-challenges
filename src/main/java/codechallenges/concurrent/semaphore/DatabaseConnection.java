package codechallenges.concurrent.semaphore;

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

    @Override
    public void write(String value) {

    }

    @Override
    public String read() {
        return null;
    }

}
