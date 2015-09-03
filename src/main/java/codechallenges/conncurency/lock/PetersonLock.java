package codechallenges.conncurency.lock;

/**
 * PetersonLock for mutual exclusion in a two-process system.
 *
 * Satisfies mutual exclusion, progress and freedom from starvation
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
        }
    }

    @Override
    public void release(int pid) {
        requested[pid] = false;
    }

}
