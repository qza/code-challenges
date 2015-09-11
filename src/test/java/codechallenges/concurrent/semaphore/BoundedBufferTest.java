package codechallenges.concurrent.semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * BoundedBuffer test class
 */
public class BoundedBufferTest {
    
    public static final int PRODUCER_COUNT = 10;
    
    public static final int CONSUMER_COUNT = 20;
    
    
    Buffer<Integer> boundedBuffer = new BoundedBuffer<>(Integer.class, PRODUCER_COUNT / 2);

    Random random = new Random();

    AtomicInteger counter = new AtomicInteger();
    
    List<Integer> fetchedItems = new ArrayList<>();
    

    @Test
    public void shouldAssertThatAllItemsAreFetched() throws Exception {

        List<Callable<Integer>> workers = new ArrayList<>();
        
        for (int i = 0; i < PRODUCER_COUNT; i++) {
            workers.add(new BufferProducerCallable(i, boundedBuffer, counter));
        }
        
        for (int i = 0; i < CONSUMER_COUNT; i++) {
            workers.add(new BufferConsumerCallable(i, boundedBuffer, fetchedItems));
        }
                
        ExecutorService executorService = Executors.newFixedThreadPool(workers.size());
        
        for(Callable<Integer> worker: workers) {
            executorService.submit(worker);
        }
        
        Thread.sleep(5000);
                
        assertEquals(PRODUCER_COUNT, fetchedItems.size());
    }
    
    
}
