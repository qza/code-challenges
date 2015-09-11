package codechallenges.concurrent.semaphore;

/**
 * ReadWriteResource interface
 * 
 * Contract for resources that enable read and write operations.
 * 
 * @param <T> Type of storable resource
 */
public interface ReadWriteResource<T> {

    void write(T value);

    T read();

}
