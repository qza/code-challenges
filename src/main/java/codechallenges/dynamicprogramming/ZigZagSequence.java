package codechallenges.dynamicprogramming;

import static java.lang.Math.max;
import java.util.Arrays;

/**
 * ZigZagSequence
 *
 * A sequence of numbers is called a zig-zag sequence when differences between
 * successive numbers strictly alternate between positive and negative.
 *
 * @see http://community.topcoder.com/stat?c=problem_statement&pm=1259
 *
 */
public class ZigZagSequence {

    public int[] solve(int[] sequence) {

        int[] difs = new int[sequence.length];
        int[] values = new int[sequence.length];

        Arrays.fill(difs, 0);

        values[0] = 1;
        values[1] = values[0] != values[1] ? 2 : 1;

        for (int i = 2; i < sequence.length; i++) {
            int prediff = sequence[i - 1] - sequence[i - 2];
            int diff = sequence[i] - sequence[i - 1];
            if ((prediff <= 0 && diff > 0) || (prediff >= 0 && diff < 0)) {
                values[i] = values[i - 1] + 1;
            } else {
                values[i] = diff == 0 ? 1 : 2;
            }
        }

        int maxIndex = 0, maxValue = 1;
        for (int i = 1; i < values.length; i++) {
            if (values[i] > maxValue) {
                maxIndex = i;
                maxValue = values[i];
            }
        }

        int[] result = new int[maxValue];
        for (int counter = 0, i = maxIndex - maxValue + 1;
                i < max(maxIndex + 1, maxValue); i++, counter++) {
            result[counter] = sequence[i];
        }

        return result;
    }

    public static void main(String[] args) {
        ZigZagSequence solver = new ZigZagSequence();
        int[] sequence = new int[]{0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0};
        int[] expected = new int[]{1, 0, 1, 0, 1, 0};
        int[] result = solver.solve(sequence);
        boolean asExpected = Arrays.equals(expected, result);
        System.out.println(asExpected);
        assert asExpected;
    }

}
