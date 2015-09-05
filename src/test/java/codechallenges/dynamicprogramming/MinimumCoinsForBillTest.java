package codechallenges.dynamicprogramming;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * MinimumCoinsForBill test class
 *
 * @author qza
 */
public class MinimumCoinsForBillTest {
    
    MinimumCoinsForBill solver = new MinimumCoinsForBill();
    
    @Test
    public void shouldFind_1_For_1_And_1() {
        assertEquals(1, solver.solve(1, new int[]{1}));
    }
    
    @Test
    public void shouldFind_NoResult_For_3_And_2_4() {
        assertEquals(-1, solver.solve(3, new int[]{2, 4}));
    }
    
    @Test
    public void shouldFind_3_For_13_And_1_3_5() {
        assertEquals(3, solver.solve(13, new int[]{1,3,5}));
    }
    
    @Test
    public void shouldFind_4_For_14_And_1_3_5() {
        assertEquals(4, solver.solve(14, new int[]{1,3,5}));
    }

}
