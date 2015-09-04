package codechallenges.conncurency.lock;

/**
 * PetersonLock for mutual exclusion in a two-process system.
 *
 * Satisfies mutual exclusion, progress and freedom from starvation.
 *
 * Implementation is done applying busy wait. When process is unable to access
 * critical section, it loops while enter condition is not true. This type of
 * waiting is called busy wait.
 * 
 * As each of the processed can update instance variable "turn", this variable
 * needs to be marked as volatile. Without the volatile, visibility problem
 * exists. This is problem related to threads and occurs when one thread doesn't
 * see the results of other thread as it is not yet written back to main memory.
 * One thread can read value from CPU cache and in such situations deadlocks can
 * occur.
 * 
 */
public class PetersonLock implements Lock {

    boolean[] requested = {false, false};
    volatile int turn = 1;

    @Override
    public void acquire(int pid) {
        int otherTurn = 1 - pid;
        requested[pid] = true;
        turn = otherTurn;
        while (requested[otherTurn] && turn == otherTurn) {
            // warning! busy wait
        }
    }

    @Override
    public void release(int pid) {
        requested[pid] = false;
    }

}
