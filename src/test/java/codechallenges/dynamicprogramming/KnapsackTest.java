package codechallenges.dynamicprogramming;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertArrayEquals;

import codechallenges.dynamicprogramming.Knapsack;

/**
 *
 * @author qza
 */
@RunWith(Parameterized.class)
public class KnapsackTest {
    
    static final int MAX_WEIGHT = 100;

    int[][] items;
    int[][] expected;

    public KnapsackTest(int[][] items, int[][] expected) {
        this.items = items;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<int[][][]> parameters() {
        int[][][][] params = new int[][][][]{
            {
                {{20, 2000}, {10, 1200}, {12, 1000}, {30, 5000}, {15, 2000}, {5, 500}},
                {{10, 1200}, {30, 5000}, {30, 5000}, {30, 5000}}
            },
            {
                {{10, 200}, {20, 200}, {30, 250}, {40, 1000}},
                {{10, 200}, {10, 200}, {40, 1000}, {40, 1000}}
            }
        };
        return Arrays.asList(params);
    }

    @Test
    public void shouldFindExpectedLongestSequences() {
        Knapsack solver = new Knapsack();
        assertArrayEquals(expected, solver.solve(MAX_WEIGHT, items));
    }

}
