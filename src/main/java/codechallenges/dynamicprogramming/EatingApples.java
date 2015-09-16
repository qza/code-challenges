package codechallenges.dynamicprogramming;

import static java.lang.Math.max;
import java.util.Arrays;

/**
 * Eating apples
 *
 * A table composed of N x M cells, each having a certain quantity of apples, is
 * given. You start from the upper-left corner. At each step you can go down or
 * right one cell. Find the maximum number of apples you can collect.
 *
 * https://www.topcoder.com/community/data-science/data-science-tutorials/dynamic-programming-from-novice-to-advanced/
 */
public class EatingApples {

    public int solve(int[][] items) {

        int rows = items.length;
        int columns = items[0].length;
        int[][] amounts = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int up = i > 0 ? amounts[i - 1][j] : 0;
                int left = j > 0 ? amounts[i][j - 1] : 0;
                amounts[i][j] = items[i][j] + max(up, left);
            }
        }

        return amounts[rows - 1][columns - 1];
    }

    public static void main(String[] args) {
        EatingApples solver = new EatingApples();
        int[][] apples = new int[][]{
            {1, 2, 3},
            {1, 2, 3},
            {1, 2, 3}
        };
        int amount = solver.solve(apples);
        System.out.println("amount of apples: " + amount);
    }

}
