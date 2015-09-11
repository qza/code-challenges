package codechallenges.concurrent.semaphore;

import codechallenges.concurrent.CounterHistogramThread;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * BoundedBuffer test class
 */
public class BoundedBufferTest {
    
    public static final int PRODUCER_COUNT = 20;
    
    public static final int CONSUMER_COUNT = 10;
    
    Buffer boundedBuffer = new BoundedBuffer(PRODUCER_COUNT);

    Random random = new Random();

    AtomicInteger counter = new AtomicInteger(0);

    @Test
    public void shoudProveMutualExclusion() throws Exception {

        for (int i = 0; i < PRODUCER_COUNT; i++) {
            BufferProducerThread producerThread = new BufferProducerThread(i, boundedBuffer, counter);
            producerThread.start();
        }
        
        for (int i = 0; i < CONSUMER_COUNT; i++) {
            BufferConsumerThread consumerThread = new BufferConsumerThread(i, boundedBuffer, counter);
            consumerThread.start();
        }

        CounterHistogramThread checkThread = new CounterHistogramThread(100, 100, counter);
        checkThread.start();
        checkThread.join();

        int[] results = checkThread.getResults();
        for (int i = 0; i < results.length; i++) {
            assertTrue(results[i] < PRODUCER_COUNT);
        }
    }
    
    
}
