package codechallenges.dynamicprogramming;

import java.util.Arrays;

/**
 * CountingSort
 *
 * @author qza
 */
public class CountingSort {

    public int[] solve(int[] sequence) {

        int[] result = new int[sequence.length];

        for (int i = 0; i < sequence.length; i++) {

            int newIndex = 0;
            
            for (int j = 0; j < sequence.length; j++) {
                if (sequence[i] > sequence[j]) {
                    newIndex += 1;
                }
            }           
            
            result[newIndex] = sequence[i];
        }
        return result;
    }

    public static void main(String[] args) {
        CountingSort solver = new CountingSort();
        int[] sequence = new int[]{6, 2, 3, 1, 5};
        int[] result = solver.solve(sequence);
        System.out.println(" sequence: " + Arrays.toString(sequence));
        System.out.println("   result: " + Arrays.toString(result));
    }

}
