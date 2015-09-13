package codechallenges.concurrent.semaphore.rw;

import codechallenges.concurrent.Concurrent;

import java.util.Date;
import java.util.Map;

/**
 * Writer callable
 *
 * Simulates writing values into {@link Database}
 */
public class WriterThread extends Thread  {

    private final DatabaseProtocol protocol;
    private final Database<Date> database;

    private final Map<Date, Date> writes;
    private final Long recordId;

    WriterThread(Database<Date> database, DatabaseProtocol protocol, Map<Date, Date> writes, Long recordId) {
        this.database = database;
        this.protocol = protocol;
        this.writes = writes;
        this.recordId = recordId;
    }

    @Override
    public void run() {
        protocol.startWrite();
        for (int i = 0; i < 10; i++) {
            Date value = new Date();
            database.insert(recordId, value);
            writes.put(value, value);
            System.out.println("wrote [id: " + recordId + "] [value: " + value + "]");
            Concurrent.sleepFor(100);
        }
        protocol.endWrite();
    }

}
