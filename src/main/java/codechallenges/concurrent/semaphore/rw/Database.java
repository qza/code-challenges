package codechallenges.concurrent.semaphore.rw;

import java.util.HashMap;
import java.util.Map;

/**
 * Database
 *
 * Enables inserting and reading values
 *
 * @param <T> type of stored data
 */
public class Database<T> {

    final Map<Long, T> data = new HashMap<>();

    public void insert(Long id, T value) {
        data.put(id, value);
    }
    
    public T select(Long id) {
        return data.get(id);
    }

}
