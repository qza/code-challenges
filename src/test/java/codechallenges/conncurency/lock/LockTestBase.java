package codechallenges.conncurency.lock;

/**
 * Base class for Lock tests
 */
public abstract class LockTestBase {
    
    protected static void waitfor(int miliseconds) {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }

}
