package codechallenges.dynamicprogramming;

import java.util.Arrays;

/**
 *
 * Knapsack
 *
 * Given n items of weight wi and value vi, find the items that should be taken
 * such that the weight is less than the maximum weight W and the corresponding
 * total value is maximum.
 *
 * <br>
 *
 * <strong>Example</strong>: Boat can carry some maximum weight and there are
 * many items to ship. Each of the items have weight and value. Goal is to
 * maximum shipment.
 */
public class Knapsack {

    public int[][] solve(int weight, int[][] items) {

        int[] values = new int[weight + 1];
        int[] paths = new int[weight + 1];

        Arrays.fill(values, 0);
        Arrays.fill(paths, 0);

        for (int w = 1; w <= weight; w++) {

            values[w] = values[w - 1];

            for (int i = 0; i < items.length; i++) {

                int wi = items[i][0];
                int vi = items[i][1];

                if (w - wi >= 0 && values[w - wi] + vi > values[w]) {

                    values[w] = values[w - wi] + vi;
                    paths[w] = i;
                }
            }
        }

        int resultIndex = 0;
        int[][] result = new int[weight][2];

        for (int i = weight; i > 0;) {

            int[] previous = items[paths[i]];
            result[resultIndex] = previous;
            resultIndex += 1;
            i = i - previous[0];
        }

        return Arrays.copyOfRange(result, 0, resultIndex);

    }

    public static void main(String[] args) {

        Knapsack solver = new Knapsack();

        int weight = 100;
        int[][] items = new int[][]{
            {20, 2000}, {10, 1200}, {12, 1000}, {30, 5000}, {15, 2000}, {5, 500}
        };

        int totalWeight = 0, totalValue = 0;

        int[][] result = solver.solve(weight, items);

        for (int[] item : result) {
            totalWeight += item[0];
            totalValue += item[1];
            System.out.println("item: " + Arrays.toString(item));
        }

        System.out.println("");
        System.out.println("total weight: " + totalWeight);
        System.out.println("total value:" + totalValue);
    }

}
