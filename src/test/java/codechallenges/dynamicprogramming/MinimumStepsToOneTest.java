package codechallenges.dynamicprogramming;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 
 */
public class MinimumStepsToOneTest {
    
    MinimumStepsToOne solver = new MinimumStepsToOne();
    
    @Test
    public void shouldFind0AsMinimumStepsForMinus1() {
        assertEquals(0, solver.solve(-1));
    }
    
    @Test
    public void shouldFind0AsMinimumStepsFor0() {
        assertEquals(0, solver.solve(0));
    }
    
    @Test
    public void shouldFind0AsMinimumStepsFor1() {
        assertEquals(0, solver.solve(1));
    }
    
    @Test
    public void shouldFind1AsMinimumStepsFor2() {
        assertEquals(1, solver.solve(2));
    }
    
    @Test
    public void shouldFind1AsMinimumStepsFor3() {
        assertEquals(1, solver.solve(3));
    }
    
    @Test
    public void shouldFind2AsMinimumStepsFor4() {
        assertEquals(2, solver.solve(4));
    }
    
    @Test
    public void shouldFind3AsMinimumStepsFor5() {
        assertEquals(3, solver.solve(5));
    }
    
    @Test
    public void shouldFind2AsMinimumStepsFor6() {
        assertEquals(2, solver.solve(6));
    }
    
    @Test
    public void shouldFind3AsMinimumStepsFor7() {
        assertEquals(3, solver.solve(7));
    }
    
    @Test
    public void shouldFind3AsMinimumStepsFor8() {
        assertEquals(3, solver.solve(8));
    }
    
    @Test
    public void shouldFind2AsMinimumStepsFor9() {
        assertEquals(2, solver.solve(9));
    }
    
    @Test
    public void shouldFind3AsMinimumStepsFor10() {
        assertEquals(3, solver.solve(10));
    }
    
    @Test
    public void shouldFind3AsMinimumStepsFor11() {
        assertEquals(3, solver.solve(10));
    }
    
    @Test
    public void shouldFind3AsMinimumStepsFor12() {
        assertEquals(3, solver.solve(12));
    }
    
    @Test
    public void shouldFind4AsMinimumStepsFor13() {
        assertEquals(4, solver.solve(13));
    }
    
    @Test
    public void shouldFind4AsMinimumStepsFor14() {
        assertEquals(4, solver.solve(14));
    }
    
    @Test
    public void shouldFind4AsMinimumStepsFor15() {
        assertEquals(4, solver.solve(15));
    }
    
    @Test
    public void shouldFind4AsMinimumStepsFor20() {
        assertEquals(4, solver.solve(20));
    }
        
}
