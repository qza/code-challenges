package codechallenges.conncurency.lock;

/**
 * Memory consistency
 *
 * Errors in concurrent environments can occur when different threads have
 * inconsistent views of what should be the same data.
 *
 * By establishing the happens-before relationship, there is a guarantee that
 * memory writes by one specific statement are visible to another specific
 * statement.
 *
 * In Java, there are many actions that establish happens-before relation:
 *
 * <strong>volatile</strong> - every write to volatile variable happens-before
 * every subsequent read of that variable
 * 
 * <strong>synchronization</strong> - invocation of synchronized method
 * automatically establish happens-before relation with any further invocation
 * of synchronized methods on the same object.
 *
 * <strong>Thread.start</strong> - statement happens-before every statement
 * executed by that thread
 *
 * <strong>Thread.join</strong> - when thread terminates and invocation of
 * join() on that thread returns, all statement executed by terminated thread
 * happens-before all actions subsequent to successful join() return
 *
 */
public class MemoryConsistency {
    
    volatile int shared = 0;
    
}
