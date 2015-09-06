package codechallenges.concurrent;

/**
 * Concurrent
 * 
 * Concurrent utilities
 * 
 * @author qza
 */
public class Concurrent {

    private Concurrent() {
        // private constructor of utility class
    }

    public static void waitfor(int miliseconds) {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }

}
