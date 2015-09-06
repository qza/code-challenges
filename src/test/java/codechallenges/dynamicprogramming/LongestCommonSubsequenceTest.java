package codechallenges.dynamicprogramming;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertArrayEquals;

/**
 *
 * @author qza
 */
@RunWith(Parameterized.class)
public class LongestCommonSubsequenceTest {

    int[] sequenceA;
    int[] sequenceB;
    int[] expected;

    public LongestCommonSubsequenceTest(int[] sequenceA, int[] sequenceB, int[] expected) {
        this.sequenceA = sequenceA;
        this.sequenceB = sequenceB;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<int[][]> parameters() {
        int[][][] params = new int[][][]{
            {{0}, {0}, {0}},
            {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}},
            {{1, 5, 2, 3, 4, 1}, {2, 3, 4}, {2, 3, 4}},
            {{0, 1, 5, 2, 3, 1}, {0, 1, 5}, {0, 1, 5}},
            {{0, 1, 5, 2, 3, 4, 5, 6, 1, 2}, {2, 7, 4, 5, 6}, {4, 5, 6}}
        };
        return Arrays.asList(params);
    }

    @Test
    public void shouldFindExpectedLongestSequences() {
        LongestCommonSubsequence solver = new LongestCommonSubsequence();
        assertArrayEquals(expected, solver.solve(sequenceA, sequenceB));
    }

}
