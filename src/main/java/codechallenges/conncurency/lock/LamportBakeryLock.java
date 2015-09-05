package codechallenges.conncurency.lock;

/**
 * <Lamport Bakery Lock implementation.
 *
 * This algorithm enables mutual exclusion for N processes. The basic idea is as
 * follows: each process comes into waiting room where it gets unique number,
 * greater than the last number assigned for the last process that requested
 * critical section. Then it periodically checks weather assigned number is the
 * next one. When given number is next one, process enters critical section.
 *
 * This algorithm also applies busy wait that is described in {@link
 * PetersonLock}
 *
 * As each of the processes can update instance variables "numbers" and
 * "choosing", but only single position, these variables can be defined without
 * "volatile" as there is no visibility issue.
 *
 * @see Lock
 */
public class LamportBakeryLock implements Lock {

    private final int[] numbers;
    private final boolean[] choosing;

    public LamportBakeryLock(int processCount) {
        this.numbers = new int[processCount];
        this.choosing = new boolean[processCount];
        for (int i = 0; i < processCount; i++) {
            this.numbers[i] = 0;
            this.choosing[i] = false;
        }
    }

    @Override
    public void acquire(int pid) {

        if (pid > numbers.length - 1) {
            return;
        }

        choosing[pid] = true;

        for (int i = 0; i < numbers.length; i++) {
            numbers[pid] = max(numbers[pid], numbers[i]);
        }

        numbers[pid] += 1;
        choosing[pid] = false;

        for (int i = 0; i < numbers.length; i++) {

            while (choosing[i]) {
                // busy wait
            }

            while (numbers[i] != 0
                    && ((numbers[i] < numbers[pid])
                    || (numbers[i] == numbers[pid] && i < pid))) {
                // busy wait
            }
        }
    }

    @Override
    public void release(int pid) {
        numbers[pid] = 0;
    }

    private int max(int a, int b) {
        return a >= b ? a : b;
    }

}
