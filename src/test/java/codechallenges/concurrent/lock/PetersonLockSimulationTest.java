package codechallenges.concurrent.lock;

import codechallenges.concurrent.CounterHistogramThread;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * PetersonLock simulation class for testing mutual exclusion
 */
public class PetersonLockSimulationTest {

    Lock petersonLock = new PetersonLock();

    Random random = new Random();

    AtomicInteger counter = new AtomicInteger(0);

    @Test
    public void shoudProveMutualExclusion() throws Exception {

        LockThread p0 = new LockThread(0, petersonLock, counter);
        p0.start();

        LockThread p1 = new LockThread(1, petersonLock, counter);
        p1.start();

        CounterHistogramThread checkThread = new CounterHistogramThread(20, 100, counter);
        checkThread.start();
        checkThread.join();

        int[] results = checkThread.getResults();
        for (int i = 0; i < results.length; i++) {
            assertTrue(results[i] < 2);
        }
    }

}
