package codechallenges.concurrent.lock;

/**
 * PetersonLock for mutual exclusion in a two-process system.
 *
 * Satisfies mutual exclusion, progress and freedom from starvation.
 *
 * Implementation is done applying busy wait. When process is unable to access
 * critical section, it loops while enter condition is not true. This type of
 * waiting is called busy wait.
 *
 * As each of the processes can update instance variable "turn", this variable
 * needs to be marked as <code>volatile</code>. Without the
 * <code>volatile</code>, there is a visibility problem between threads.
 *
 * @see Lock
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
