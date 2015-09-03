package codechallenges.conncurency.lock;

import java.util.Random;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * PetersonLock test class covering mutual exclusion, progress and freedom from
 * starvation
 */
public class PetersonLockSimulationTest {

    Lock petersonLock = new PetersonLock();

    Random random = new Random();

    int inCriticalSection = 0;

    class PetersonLockThread extends Thread {

        int pid;

        PetersonLockThread(int pid) {
            this.pid = pid;
        }

        @Override
        public void run() {
            for (int i = 0; i < Integer.MAX_VALUE / 2; i++) {
                petersonLock.acquire(pid);
                synchronized (this) {
                    inCriticalSection++;
                    System.out.println("in critical: " + pid);
                    waitfor(random.nextInt(500));
                    inCriticalSection--;
                }
                petersonLock.release(pid);
                synchronized(this) {
                    System.out.println("not in critical: " + pid);
                    waitfor(random.nextInt(500));
                }
            }
        }

    }

    class CriticalSectionCheckThread extends Thread {

        int checksCount;
        int[] results;

        public CriticalSectionCheckThread(int checksCount) {
            this.checksCount = checksCount;
            this.results = new int[checksCount];
        }

        @Override
        public void run() {
            for (int i = 0; i < checksCount; i++) {
                System.out.println("\t\t\t [count: " + inCriticalSection + "]");
                results[i] = inCriticalSection;
                waitfor(100);
            }
        }

    }

    @Test
    public void shoudProveMutualExclusion() throws Exception {

        PetersonLockThread p0 = new PetersonLockThread(0);
        p0.start();

        PetersonLockThread p1 = new PetersonLockThread(1);
        p1.start();

        CriticalSectionCheckThread checkThread = new CriticalSectionCheckThread(100);
        checkThread.start();
        checkThread.join();

        int[] results = checkThread.results;
        for (int i = 0; i < results.length; i++) {
            assertTrue(results[i] < 2);
        }
    }
    
    @Test
    public void shoudProveProgress() throws Exception {

        PetersonLockThread p0 = new PetersonLockThread(0);
        p0.start();

        PetersonLockThread p1 = new PetersonLockThread(1);
        p1.start();

        CriticalSectionCheckThread checkThread = new CriticalSectionCheckThread(100);
        checkThread.start();
        checkThread.join();

        int[] results = checkThread.results;
        for (int i = 0; i < results.length; i++) {
            assertTrue(results[i] < 2);
        }
    }

    static void waitfor(int miliseconds) {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}
