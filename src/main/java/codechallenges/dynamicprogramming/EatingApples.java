package codechallenges.dynamicprogramming;

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
        return 0;
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
