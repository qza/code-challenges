package codechallenges.concurrent.semaphore.rw;

/**
 * ReadWriteResource interface
 *
 * Contract for resources that enable read and write operations.
 *
 * @param <T> Type of storable resource
 */
public interface ReadWriteResource<T> {

    void write(Long index, T value);

    T read(Long index);

}
