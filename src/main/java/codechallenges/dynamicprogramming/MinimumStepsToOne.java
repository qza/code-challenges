package codechallenges.dynamicprogramming;

/**
 *
 * Problem Statement: On a positive integer, you can perform any one of the
 * following 3 steps. 1.) Subtract 1 from it. ( n = n - 1 ) , 2.) If its
 * divisible by 2, divide by 2. ( if n % 2 == 0 , then n = n / 2 ) , 3.) If its
 * divisible by 3, divide by 3. ( if n % 3 == 0 , then n = n / 3 ).
 *
 * Now the question is, given a positive integer n, find the minimum number of
 * steps that takes n to 1
 *
 * Examples: 1.)For n = 1 , output: 0 2.) For n = 4 , output: 2 ( 4 /2 = 2 /2 =
 * 1 ) 3.) For n = 7 , output: 3 ( 7 -1 = 6 /3 = 2 /2 = 1 )
 *
 * This problem can be solved with dynamic programming and O(n) complexity. Idea
 * is to calculate minimum steps for each number <code>1 <= i <= n </code>
 * Minimum steps for each next number can be found based on steps for previous
 * number. Result for each number is initialized with the worst case (+1 for
 * each step). Then there is a check for shorter combination in case that this
 * number is dividable by 2 or 3.
 */
public class MinimumStepsToOne {

    int solve(int n) {

        if (n <= 1) {
            return 0;
        }

        int counter;
        int[] results = new int[n + 1];

        results[1] = 0;

        for (counter = 2; counter <= n; counter++) {

            results[counter] = 1 + results[counter - 1];

            if (counter % 2 == 0) {
                results[counter] = min(results[counter], (1 + results[counter / 2]));
            }

            if (counter % 3 == 0) {
                results[counter] = min(results[counter], (1 + results[counter / 3]));
            }
        }

        return results[n];
    }

    private int min(int a, int b) {
        return a <= b ? a : b;
    }

    public static void main(String[] args) {
        MinimumStepsToOne solver = new MinimumStepsToOne();
        for (int i = 0; i < 20; i++) {
            System.out.println("n: " + i + ", result: " + solver.solve(i));
        }
    }

}
