package codechallenges.dynamicprogramming;

import java.util.Arrays;

/**
 * ZigZagSequence
 *
 * A sequence of numbers is called a zig-zag sequence when differences between
 * successive numbers strictly alternate between positive and negative.
 *
 * @see http://community.topcoder.com/stat?c=problem_statement&pm=1259
 * 
 */
public class ZigZagSequence {

    public int[] solve(int[] sequence) {

        int[] difs = new int[sequence.length];
        int[] values = new int[sequence.length];
        
        Arrays.fill(difs, 0);
        
        values[0] = 1;
        values[1] = values[0] != values[1] ? 2 : 1;
        
        for(int i = 2; i < sequence.length; i++) {
            int prediff = sequence[i - 1] - sequence[i-2];
            int diff = sequence[i] - sequence[i];
        } 
        
        return null;
    }
    
    public static void main(String[] args) {
        ZigZagSequence solver = new ZigZagSequence();
        int[] sequence = new int[]{0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0};
        int[] expected = new int[]{1, 0, 1, 0, 1, 0};
        assert Arrays.equals(expected, solver.solve(sequence));
    }

}
