/**
 * This class provides methods for counting and generating permutations with a
 * specific number of inversions.
 * An inversion is a pair of indices (i,j) such that i < j and a[i] > a[j].
 * 
 * @author Princeton University
 * @version 1.0
 */
public class Inversions {

    /**
     * Returns the number of inversions in the permutation a[].
     * 
     * @param a the permutation array
     * @return the number of inversions in the permutation
     */
    public static long count(int[] a) {
        long inversionCount = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    inversionCount++;
                }
            }
        }

        return inversionCount;
    }

    /**
     * Returns a permutation of length n with exactly k inversions.
     * 
     * @param n the length of the permutation
     * @param k the number of inversions
     * @return a permutation array with exactly k inversions
     */
    public static int[] generate(int n, long k) {
        // Create array to hold our permutation
        int[] permutationArr = new int[n];

        // Special case: if n ≤ 1, return array with no inversions
        if (n <= 1) {
            for (int i = 0; i < n; i++) {
                permutationArr[i] = i;
            }
            return permutationArr;
        }

        // Special case: maximum possible inversions - return reverse-ordered
        // permutation
        // Maximum inversions = n*(n-1)/2, which happens when array is in reverse order
        if (k == ((long) n) * (n - 1) / 2) {
            for (int i = 0; i < n; i++) {
                permutationArr[i] = n - i - 1;
            }
            return permutationArr;
        }

        // For other cases, use a greedy approach
        int elementsPlaced = 1; // Keeps track of how many elements we've placed
        long remainingInversions = k; // Remaining inversions we need to create

        // Phase 1: Place larger elements at the beginning to create inversions
        // Each time we put n-elementsPlaced at position elementsPlaced-1, we create
        // (n-elementsPlaced) inversions
        while (remainingInversions >= ((long) n) - elementsPlaced) {
            // Place the value (n-elementsPlaced) at index (elementsPlaced-1)
            permutationArr[elementsPlaced - 1] = n - elementsPlaced;

            // Subtract the number of inversions created from our remaining target
            // Placing n-elementsPlaced at position elementsPlaced-1 creates
            // (n-elementsPlaced) inversions
            remainingInversions = remainingInversions - n + elementsPlaced;

            // Move to the next position
            elementsPlaced++;
        }

        // Phase 2: Place the next largest value to create exactly the remaining
        // inversions
        // Calculate where to place the next value (n-elementsPlaced) to create
        // 'remainingInversions' more inversions
        int targetPosition = n - (int) remainingInversions - 1;
        permutationArr[targetPosition] = n - elementsPlaced;

        // Phase 3: Fill in remaining positions with values in ascending order
        // For positions between elementsPlaced-1 and targetPosition, fill with 0, 1, 2,
        // etc.
        for (int i = elementsPlaced - 1; i < targetPosition; i++) {
            permutationArr[i] = i - elementsPlaced + 1;
        }

        // For positions after targetPosition, fill with values continuing the sequence
        for (int i = targetPosition + 1; i < n; i++) {
            permutationArr[i] = i - elementsPlaced;
        }

        return permutationArr;
    }

    /**
     * Takes an integer n and a long k as command-line arguments,
     * and prints a permutation of length n with exactly k inversions.
     * 
     * @param args Command line arguments:
     *             args[0]: length of the permutation (n)
     *             args[1]: number of inversions (k)
     */
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);

        int[] permutationArray = generate(n, k);
        for (int i = 0; i < permutationArray.length; i++) {
            System.out.print(permutationArray[i] + " ");
        }
        System.out.println();

        // Verify by counting inversions
        System.out.println(count(permutationArray));
    }
}
