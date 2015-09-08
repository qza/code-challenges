package codechallenges.dynamicprogramming;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertArrayEquals;

/**
 * ChainMatrixMultiplication test class
 *
 * @author qza
 */
@RunWith(Parameterized.class)
public class ChainMatrixMultiplicationTest {

    int[][] matrixA;
    int[][] matrixB;

    int[][] expected;

    public ChainMatrixMultiplicationTest(int[][] matrixA, int[][] matrixB, int[][] expected) {
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.expected = expected;
    }

    @Test
    public void shouldProperlyMultiplyTwoMatrices() {
        ChainMatrixMultiplication solver = new ChainMatrixMultiplication();
        assertArrayEquals(expected, solver.solve(matrixA, matrixB));
    }

    @Parameterized.Parameters
    public static Collection<int[][][]> parameters() {
        int[][][][] params = new int[][][][]{
            {
                {
                    {1, 100},
                    {2, 200},
                    {3, 300}
                },
                {
                    {1, 10, 100, 1000},
                    {10, 100, 1000, 10000}
                },
                {
                    {1001, 10010, 100100, 1001000},
                    {2002, 20020, 200200, 2002000},
                    {3003, 30030, 300300, 3003000}
                }
            },
            {
                {
                    {0, 10, 100},
                    {10, 100, 1000}
                },
                {
                    {0},
                    {10},
                    {100}
                },
                {
                    {10100},
                    {101000}
                }
            }
        };
        return Arrays.asList(params);
    }

}
