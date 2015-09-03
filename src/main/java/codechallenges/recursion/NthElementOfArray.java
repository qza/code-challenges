package codechallenges.recursion;

/**
 *
 * Problem Statement: Given that first two elements of array are 3 and 3, find
 * Nth element of array where each next element is equal to product of previous
 * two elements
 *
 * Array: 3 3 9 27 243 6561 ..
 */
public class NthElementOfArray {

    public long nthElementOfArrayWithRecursion(long x, long y, int n, int counter) {
        return (counter < n - 2) ? nthElementOfArrayWithRecursion(y, x * y, n, ++counter) : y;
    }

    public static void main(String[] args) {
        int n = 6; //find 6th element
        NthElementOfArray solver = new NthElementOfArray();
        System.out.println(solver.nthElementOfArrayWithRecursion(3, 3, n, 0));
    }

}
