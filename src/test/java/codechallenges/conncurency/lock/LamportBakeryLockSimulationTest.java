package codechallenges.conncurency.lock;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * PetersonLock simulation class for testing mutual exclusion
 */
public class LamportBakeryLockSimulationTest extends LockTestBase {
    
    static final int PROCESS_COUNT = 10;

    Lock petersonLock = new LamportBakeryLock(PROCESS_COUNT);

    Random random = new Random();

    AtomicInteger counter = new AtomicInteger(0);

    @Test
    public void shoudProveMutualExclusion() throws Exception {

        for (int i = 0; i < PROCESS_COUNT; i++) {
            CriticalSectionThread csThread = new CriticalSectionThread(i, petersonLock, counter);
            csThread.start();
        }

        CheckThread checkThread = new CheckThread(100, counter);
        checkThread.start();
        checkThread.join();

        int[] results = checkThread.results;
        for (int i = 0; i < results.length; i++) {
            assertTrue(results[i] < 2);
        }
    }

}
