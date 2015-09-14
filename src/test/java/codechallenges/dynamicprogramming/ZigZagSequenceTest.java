package codechallenges.dynamicprogramming;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertArrayEquals;

/**
 * ZigZagSequence test class
 */
@RunWith(Parameterized.class)
public class ZigZagSequenceTest {

    int[] sequence;
    int[] expected;

    public ZigZagSequenceTest(int[] sequence, int[] expected) {
        this.sequence = sequence;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<int[][]> parameters() {
        int[][][] params = new int[][][]{
            {{1, 10, 2, 20, 3, 30}, {1, 10, 2, 20, 3, 30}},
            {{1, 6, 8, 2, 3, 5, 6, 5, 2, 0}, {6, 8, 2, 3}},
            {{0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0}, {1, 0, 1, 0, 1, 0}}
        };
        return Arrays.asList(params);
    }

    @Test
    public void shouldFindExpectedLongestSequences() {
        ZigZagSequence solver = new ZigZagSequence();
        assertArrayEquals(expected, solver.solve(sequence));
    }

}
