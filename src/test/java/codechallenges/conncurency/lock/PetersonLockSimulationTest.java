package codechallenges.conncurency.lock;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * PetersonLock simulation class for testing mutual exclusion
 */
public class PetersonLockSimulationTest extends LockTestBase {

    Lock petersonLock = new PetersonLock();

    Random random = new Random();

    AtomicInteger counter = new AtomicInteger(0);

    @Test
    public void shoudProveMutualExclusion() throws Exception {

        CriticalSectionThread p0 = new CriticalSectionThread(0, petersonLock, counter);
        p0.start();

        CriticalSectionThread p1 = new CriticalSectionThread(1, petersonLock, counter);
        p1.start();

        CheckThread checkThread = new CheckThread(100, counter);
        checkThread.start();
        checkThread.join();

        int[] results = checkThread.results;
        for (int i = 0; i < results.length; i++) {
            assertTrue(results[i] < 2);
        }
    }

}