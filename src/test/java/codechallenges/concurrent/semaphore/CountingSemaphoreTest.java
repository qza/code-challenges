package codechallenges.concurrent.semaphore;

import codechallenges.concurrent.CounterHistogramThread;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * CountingSemaphore test class for mutual exclusion
 * 
 */
public class CountingSemaphoreTest {

    public static final int PROCESS_COUNT = 10;
    
    public static final int PERMISSIONS_COUNT = 3;

    Semaphore binarySemaphore = new CountingSemaphore(PERMISSIONS_COUNT);

    Random random = new Random();

    AtomicInteger counter = new AtomicInteger(0);

    @Test
    public void shoudProveMutualExclusion() throws Exception {

        for (int i = 0; i < PROCESS_COUNT; i++) {
            SemaphoreThread csThread = new SemaphoreThread(i, binarySemaphore, counter);
            csThread.start();
        }

        CounterHistogramThread checkThread = new CounterHistogramThread(20, 200, counter);
        checkThread.start();
        checkThread.join();

        int[] results = checkThread.getResults();
        for (int i = 0; i < results.length; i++) {
            assertTrue(results[i] <= PERMISSIONS_COUNT);
        }
    }

}