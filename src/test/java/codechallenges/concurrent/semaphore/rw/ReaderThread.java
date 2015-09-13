package codechallenges.concurrent.semaphore.rw;

import codechallenges.concurrent.Concurrent;

import java.util.Date;
import java.util.Map;

/**
 * Reader callable
 *
 * Simulates reading values from {@link Database}
 */
public class ReaderThread extends Thread {

    private final DatabaseProtocol protocol;
    private final Database<Date> database;

    private final Map<Date, Date> reads;

    ReaderThread(Database database, DatabaseProtocol protocol, Map<Date, Date> reads) {
        this.database = database;
        this.protocol = protocol;
        this.reads = reads;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            protocol.startRead();
            Date item = database.select(0L);
            reads.put(new Date(), item);
            System.out.println("read: " + item);
            protocol.endRead();
            Concurrent.sleepFor(100);
        }
    }

}
