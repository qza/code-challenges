package codechallenges.dynamicprogramming;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertArrayEquals;

/**
 * CardGameOne test class
 */
@RunWith(Parameterized.class)
public class CardGameOneTest {

    int[] cards1;
    int[] cards2;
    int[] expected;

    public CardGameOneTest(int[] cards1, int[] cards2, int[] expected) {
        this.cards1 = cards1;
        this.cards2 = cards2;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<int[][]> parameters() {
        int[][][] params = new int[][][]{
            {{2, 5}, {3, 1}, {2, 3, 5}},
            {{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1}},
            {{1, 4, 6, 7, 3}, {1, 7, 1, 5, 7}, {1, 5, 6, 7}}
        };
        return Arrays.asList(params);
    }

    @Test
    public void shouldFindExpectedLongestSequences() {
        CardGameOne solver = new CardGameOne();
        assertArrayEquals(expected, solver.solve(cards1, cards2));
    }

}
