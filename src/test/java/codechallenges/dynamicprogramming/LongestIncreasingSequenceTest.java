package codechallenges.dynamicprogramming;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author qza
 */
@RunWith(Parameterized.class)
public class LongestIncreasingSequenceTest {

    int[] sequence;
    int[] expected;

    public LongestIncreasingSequenceTest(int[] sequence, int[] expected) {
        this.sequence = sequence;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<int[][]> parameters() {
        int[][][] paramsQube = new int[][][]{
            {{0}, {0}},
            {{1, 2, 3}, {1, 2, 3}},
            {{1, 5, 2, 3, 4, 1}, {2, 3, 4}},
            {{0, 1, 5, 2, 3, 1}, {0, 1, 5}},
            {{0, 1, 5, 2, 3, 4, 5, 6, 1, 2}, {2, 3, 4, 5, 6}}
        };
        return Arrays.asList(paramsQube);
    }

    @Test
    public void shouldFindExpectedLongestSequences() {
        LongestIncreasingSequence solver = new LongestIncreasingSequence();
        assertArrayEquals(expected, solver.solve(sequence));
    }

}
