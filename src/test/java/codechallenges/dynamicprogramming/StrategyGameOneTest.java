package codechallenges.dynamicprogramming;

import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * StrategyGameOne
 *
 */
public class StrategyGameOneTest {

    public static int[][] items() {
        int[][] items = new int[][]{
            {12, 10, 4},
            {54, 18, 6},
            {55, 60, 53}
        };
        return items;
    }

    public static int[] expected() {
        int[] expected = new int[]{2, 6, 13};
        return expected;
    }

    @Test
    @Ignore
    public void shouldFindExpectedMinimumHits() {
        StrategyGameOne solver = new StrategyGameOne();
        for (int i = 0; i < items().length; i++) {
            int amount = solver.solve(items()[i]);
            assertEquals("Items: " + Arrays.toString(items()[i]) + ", amount: " + amount, expected()[i], amount);
        }
    }

}
