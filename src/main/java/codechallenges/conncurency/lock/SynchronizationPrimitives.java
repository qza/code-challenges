package codechallenges.conncurency.lock;

/**
 * Intrinsic lock AKA monitor
 *
 * In Java, each object has intrinsic lock associated with it. Java API
 * specification refers to it as monitor. Intrinsic locks play a role in both
 * aspects of synchronization: enforcing exclusive access to an object's state
 * and establishing happens-before relationships that are essential to
 * visibility.
 *
 * When a thread invokes a synchronized method, it automatically acquires the
 * intrinsic lock for that method's object and releases it when the method
 * returns. The lock release occurs even if the return was caused by an uncaught
 * exception.
 *
 * Only one thread at a time can own an object's monitor. That means that two
 * invocations of synchronized methods on the same object are not possible to
 * interleave.
 *
 * Acquiring the instance lock only blocks other threads from invoking a
 * synchronized instance method; it does not block other threads from invoking
 * an un-synchronized method, nor does it block them from invoking a static
 * synchronized method.
 *
 * Similarly, acquiring the static lock only blocks other threads from invoking
 * a static synchronized method; it does not block other threads from invoking
 * an un-synchronized method, nor does it block them from invoking a
 * synchronized instance method.
 *
 * Object locking is performed on per thread basis and this enables reentrance.
 * Thread that takes lock or object can reenter any number of synchronized
 * methods or blocks of same object on which it has already acquired lock.
 *
 */
public class SynchronizationPrimitives extends Object {

    synchronized void atomicOne() {

        // acquired monitor on object instance 
    }

    synchronized void atomicTwo() {

        // acquired monitor on object instance 
        atomicOne(); // can be done as Java supports reentrance
    }

    static synchronized void atomicOnClass() {

        // acquired monitor on Class instance
    }

}
