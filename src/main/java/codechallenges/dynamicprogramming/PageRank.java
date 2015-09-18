package codechallenges.dynamicprogramming;

import java.util.Arrays;

/**
 * PageRank
 * 
 * Calculates the final rank of given pages from the basic rank matrix
 * 
 * @link https://www.coursera.org/course/mmds
 * 
 */
public class PageRank {

    private final double B;
    private final double _B;
    private final double E;

    public PageRank() {
        B = 0.85;
        _B = 1d - B;
        E = 0.000005;
    }

    public PageRank(double b, double e) {
        this.B = b;
        this._B = 1d - b;
        this.E = e;
    }

    public double[] solve(double[][] matrix) {

        int size = matrix.length;
        double[] power = new double[size];
        Arrays.fill(power, 1d / size);

        int iterationIndex = 0;
        boolean convergence = false;

        while (!convergence && iterationIndex < 100) {

            System.out.println("power " + iterationIndex + " : " + Arrays.toString(power));

            double[] iteration = powerMatrix(power, matrix);

            convergence = isConvergence(power, iteration);

            power = iteration;

            iterationIndex += 1;
        }

        return power;
    }

    private double[] powerMatrix(double[] power, double[][] matrix) {
        int size = matrix.length;
        double[] product = new double[size];
        Arrays.fill(product, 0);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                product[i] += power[j] * matrix[i][j] * B + ((double) _B / size);
            }
        }
        return product;
    }

    private boolean isConvergence(double[] t1, double[] t2) {
        assert t1.length == t2.length;
        boolean result = true;
        for (int i = 0; (i < t1.length) && result; i++) {
            result = Math.abs(t1[i] - t2[i]) < E;
        }
        return result;
    }

    public static void main(String[] args) {

        PageRank solver = new PageRank();

        char[] chars = new char[]{'a', 'b', 'c'};
        double[][] matrix = new double[][]{
            {0, 0, 1},
            {0.5, 0, 0},
            {0.5, 1, 0}
        };

        double sum = 0d;
        double[] ranks = solver.solve(matrix);
        for (int i = 0; i < ranks.length; i++) {
            sum += ranks[i];
            System.out.println(chars[i] + ": " + ranks[i]);
        }
        System.out.println("sum:" + sum);

        System.out.println("\n\n");

        double answerASideLeft = (double) 0.95 * ranks[2];
        double answerASideRight = ((double) 0.9 * ranks[1]) + ((double) .475 * ranks[0]);
        boolean answerA = answerASideLeft == answerASideRight;

        System.out.println(".95c = .9b + .475a  ::: " + answerASideLeft + " == " + answerASideRight + "  :::   " + answerA);

        double answerBSideLeft = (double) 0.85 * ranks[0];
        double answerBSideRight = ranks[2] + ((double) 0.15 * ranks[1]);
        boolean answerB = answerBSideLeft == answerBSideRight;

        System.out.println(".85a = c + .15b  ::: " + answerBSideLeft + " == " + answerBSideRight + "  :::   " + answerB);

    }

}
