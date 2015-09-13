package codechallenges.concurrent.semaphore.rw;

/**
 * ReadWriteResource interface
 *
 * Contract for resources that enable read and write operations.
 */
public interface ReadWriteProtocol {

    void startRead();
    
    void endRead();
    
    void startWrite();
    
    void endWrite();
    
}
