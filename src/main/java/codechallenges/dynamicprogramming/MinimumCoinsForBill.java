package codechallenges.dynamicprogramming;

import java.util.Arrays;

/**
 * Minimum coins for bill
 *
 * Given a list of N coins, their values (V1, V2, … , VN), and the total sum S.
 * Find the minimum number of coins the sum of which is S (we can use as many
 * coins of one type as we want), or report that it’s not possible to select
 * coins in such a way that they sum up to S
 *
 * Example:
 *
 * V = {1, 3, 5} S = 11;
 *
 * 11 = 5 + 5 + 1;
 *
 */
public class MinimumCoinsForBill {

    public int solve(int n, int[] values) {

        int[] minimums = new int[n + 1];

        Arrays.fill(minimums, Integer.MAX_VALUE - n);

        minimums[0] = 0;

        for (int i = 1; i <= n; i++) {

            for (int v : values) {

                if (i >= v) {

                    minimums[i] = min(minimums[i], minimums[i - v] + 1);
                }

            }
        }

        return minimums[n] > n ? -1 : minimums[n];
    }

    int min(int a, int b) {
        return a <= b ? a : b;
    }

    public static void main(String[] args) {
        MinimumCoinsForBill solver = new MinimumCoinsForBill();
        int bill = 13;
        int[] coins = new int[]{1, 3, 5};
        int result = solver.solve(bill, coins);
        System.out.println(" bill = " + bill + " coins = " + Arrays.toString(coins) + " result = " + result);
    }

}
