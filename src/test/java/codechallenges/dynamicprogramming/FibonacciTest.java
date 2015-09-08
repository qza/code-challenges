package codechallenges.dynamicprogramming;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

/**
 * Fibonacci test class
 * 
 * @author qza
 */

public class FibonacciTest {
    
    final int[] expected = new int[]{1,1,2,3,5,8,13,21,34,55};

    @Test
    public void shouldHaveProperFibonacciNumbers() {
        Fibonacci solver = new Fibonacci();
        int[] fibonacci = solver.solve(10);
        assertArrayEquals(expected, fibonacci);
    }
    
}
