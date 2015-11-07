package codechallenges.concurrent.semaphore.rw;

import codechallenges.concurrent.Concurrent;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * DatabaseProtocol test class
 */
public class DatabaseProtocolTest {

    private final DatabaseProtocol protocol = new DatabaseProtocol();
    private final Database<Date> database = new Database<>();

    @Test
    public void shouldProveNoConcurrentWrites() {

        Map<Date, Date> writes0 = new HashMap<>();
        Map<Date, Date> writes1 = new HashMap<>();

        WriterThread writer0 = new WriterThread(database, protocol, writes0, 0L);
        WriterThread writer1 = new WriterThread(database, protocol, writes1, 1L);

        writer0.start();
        
        Concurrent.sleepFor(100);
        
        writer1.start();

        Concurrent.sleepFor(2000);

        Date maximumDateWrite0 = maximumDateKey(writes0);
        Date minimumDateWrite1 = minimumDateKey(writes1);

        assertTrue(minimumDateWrite1.after(maximumDateWrite0));
    }

    @Test
    public void shouldProveNotConcurrentReadWrite() throws Exception {

        Map<Date, Date> reads = new HashMap<>();
        Map<Date, Date> writes = new HashMap<>();

        WriterThread writer = new WriterThread(database, protocol, writes, 0L);
        ReaderThread reader = new ReaderThread(database, protocol, reads);

        writer.start();
        
        Concurrent.sleepFor(100);
        
        reader.start();

        Concurrent.sleepFor(2000);

        Date maximumWrite = maximumDateKey(writes);       
        Date minimumRead = minimumDateKey(reads);
        
        assertTrue(minimumRead.after(maximumWrite));
    }

    private Date minimumDateKey(Map<Date, Date> data) {
        Date minimum = new Date();
        for (Date date : data.keySet()) {
            if (date.before(minimum)) {
                minimum = date;
            }
        }
        return minimum;
    }

    private Date maximumDateKey(Map<Date, Date> data) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -1);
        Date maximum = calendar.getTime();
        for (Date date : data.keySet()) {
            if (date.after(maximum)) {
                maximum = date;
            }
        }
        return maximum;
    }

}
