package codechallenges.dynamicprogramming;

import static java.lang.Integer.max;
import java.util.Arrays;

/**
 * The Longest Common Subsequence
 *
 * Given two sequences S1 and S2, find longest common subsequence S
 *
 * @author qza
 */
public class LongestCommonSubsequence {

    public int[] solve(int[] s1, int[] s2) {

        int maxLenght = 0, maxIndex = -1;

        int[] lengths = new int[s1.length];

        for (int i = 0; i < s1.length; i++) {

            for (int j = 0; j < s2.length; j++) {

                int ii = i, jj = j, lenght = 0;

                while (ii < s1.length && jj < s2.length && s1[ii] == s2[jj]) {

                    ii += 1;
                    jj += 1;

                    lenght += 1;
                    lengths[i] = max(lengths[i], lenght);

                    maxIndex = lengths[i] > maxLenght ? i : maxIndex;
                    maxLenght = max(lengths[i], maxLenght);
                }
            }
        }

        return maxIndex != -1 ? Arrays.copyOfRange(s1, maxIndex, maxIndex + maxLenght) : null;

    }

    public static void main(String[] args) {

        LongestCommonSubsequence solver = new LongestCommonSubsequence();
        int[] a = new int[]{1, 4, 7, 4, 6, 2, 7, 4, 1}, b = new int[]{2, 4, 7};
        int[] longestCommonsSequence = solver.solve(a, b);

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(longestCommonsSequence));
    }

}