package codechallenges.dynamicprogramming;

import java.util.Arrays;

/**
 * The Longest Increasing Subsequence problem is to find the longest increasing
 * subsequence of a given sequence. Given a sequence S= {a1 , a2 , a3, a4,
 * ............., an-1, an } we have to find a longest subset such that for all
 * j and i, j < i in the subset aj < ai.
 */
public class LongestIncreasingSequence {

    int[] solve(int[] sequence) {

        int maxIndex = 0;
        int maxLength = 0;

        int[] lengths = new int[sequence.length];

        lengths[0] = 0;

        for (int i = 1; i < sequence.length; i++) {

            if (sequence[i] > sequence[i - 1]) {

                lengths[i] = lengths[i - 1] + 1;
                
                if(lengths[i] > maxLength) {
                    maxIndex = i;
                    maxLength = lengths[i];
                }
                
            } else {
                
                lengths[i] = 0;
            }
        }

        int[] lis = new int[lengths[maxIndex] + 1];

        for (int j = 0, i = maxIndex - lengths[maxIndex]; i <= maxIndex; i++) {
            lis[j++] = sequence[i];
        }

        return lis;

    }

    public static void main(String[] args) {
        LongestIncreasingSequence solver = new LongestIncreasingSequence();
        int[] sequence = new int[]{0, 1, 5, 2, 3, 2};
        int[] longestSequence = solver.solve(sequence);
        System.out.println("sequence: " + Arrays.toString(sequence));
        System.out.println(" longest: " + Arrays.toString(longestSequence));
    }

}
