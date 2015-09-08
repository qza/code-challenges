package codechallenges.dynamicprogramming;

import static java.lang.Integer.max;

/**
 * Fibonacci sequence
 *
 * @author qza
 */
public class Fibonacci {

    public int[] solve(int n) {
        int[] elements = new int[max(n, 2)];
        elements[0] = elements[1] = 1;
        for (int i = 2; i < n; i++) {
            elements[i] = elements[i - 1] + elements[i - 2];
        }
        return elements;
    }

}
