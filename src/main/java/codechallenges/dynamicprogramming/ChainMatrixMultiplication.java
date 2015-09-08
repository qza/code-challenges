package codechallenges.dynamicprogramming;

/**
 * Chain matrix multiplication
 *
 * Two matrices could only be multiplied if they have a common dimension value
 *
 */
public class ChainMatrixMultiplication {

    public int[][] solve(int[][] mxA, int[][] mxB) {

        assert mxA[0].length == mxB.length;

        int[][] result = new int[mxA.length][mxB[0].length];

        for (int i = 0; i < result.length; i++) {

            for (int j = 0; j < result[0].length; j++) {

                for (int ij = 0; ij < mxA[0].length; ij++) {

                    result[i][j] += mxA[i][ij] * mxB[ij][j];
                }
            }
        }

        return result;
    }

}
