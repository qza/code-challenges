package codechallenges.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CounterHistogramThread
 *
 * Creates histogram of counter values
 *
 * @author qza
 */
public class CounterHistogramThread extends Thread {

    private final int checksCount;
    private final long checkInterval;
    private final int[] results;

    final AtomicInteger counter;

    public CounterHistogramThread(int checksCount, long checkInterval, AtomicInteger counter) {
        this.checksCount = checksCount;
        this.checkInterval = checkInterval;
        this.results = new int[checksCount];
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < checksCount; i++) {
            results[i] = counter.intValue();
            try {
                Thread.sleep(checkInterval); // sleap in loop
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public int[] getResults() {
        return results;
    }

}
