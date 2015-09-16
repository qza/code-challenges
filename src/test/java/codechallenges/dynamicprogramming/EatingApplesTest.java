package codechallenges.dynamicprogramming;

import java.util.Arrays;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * EatingApples test class
 */
public class EatingApplesTest {

    public static int[][][] items() {
        int[][][] items = new int[][][]{
            {
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 3}
            }
        };
        return items;
    }

    public static int[] expected() {
        int[] expected = new int[]{12};
        return expected;
    }

    @Test
    public void shouldFindExpectedMaxAmounts() {
        EatingApples solver = new EatingApples();
        for (int i = 0; i < items().length; i++) {
            int amount = solver.solve(items()[i]);
            String itemsString = "{ ";
            for (int[] itemRow : items()[i]) {
                itemsString += " " + Arrays.toString(itemRow);
            }
            itemsString += " } ";
            assertEquals("Items: " + itemsString + ", amount: " + amount, expected()[i], amount);
        }
    }

}
