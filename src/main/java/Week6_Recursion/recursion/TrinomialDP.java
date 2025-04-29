package Week6_Recursion.recursion;

/**
 * A program that computes trinomial coefficients using dynamic programming.
 * The program takes two command-line arguments: n and k, and computes the
 * trinomial
 * coefficient T(n, k) using a bottom-up dynamic programming approach.
 * 
 * Usage: java TrinomialDP n k
 * 
 * @author Bryan Williamson
 */
public class TrinomialDP {

    /**
     * Computes the trinomial coefficient T(n, k) using dynamic programming.
     * 
     * The trinomial coefficient T(n, k) represents the coefficient of x^k in the
     * expansion of (1 + x + x^2)^n.
     * 
     * Recurrence relation:
     * - T(0,0) = 1
     * - T(n,k) = 0 if k < -n or k > n
     * - T(n,k) = T(n-1,k-1) + T(n-1,k) + T(n-1,k+1) otherwise
     * 
     * Example values for small n and k:
     * n\k | -3 -2 -1 0 1 2 3
     * ----+----------------------------
     * 0 | 0 0 0 1 0 0 0
     * 1 | 0 0 1 1 1 0 0
     * 2 | 0 1 2 3 2 1 0
     * 3 | 1 3 6 7 6 3 1
     * 4 | 3 9 16 19 16 9 3
     * 
     * @param n the power in the expansion
     * @param k the coefficient index
     * @return the trinomial coefficient T(n, k)
     */
    public static long trinomial(int n, int k) {
        // Base case: T(0,0) = 1
        if (n == 0 && k == 0) {
            return 1;
        }

        // Base case: T(n,k) = 0 if k is outside valid range
        if (k < -n || k > n) {
            return 0;
        }

        // Create DP table to store intermediate results
        long[][] trinomialCoefficient = new long[n + 1][n + 1];
        trinomialCoefficient[0][0] = 1;

        // Fill the DP table using the recurrence relation
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    // Special case for j=0: T(n,0) = T(n-1,0) + 2*T(n-1,1)
                    trinomialCoefficient[i][j] = trinomialCoefficient[i - 1][j]
                            + 2 * trinomialCoefficient[i - 1][j + 1];
                } else if (j == i) {
                    // Special case for j=i: T(n,i) = T(n-1,i-1)
                    trinomialCoefficient[i][j] = trinomialCoefficient[i - 1][j - 1];
                } else {
                    // General case: T(n,k) = T(n-1,k-1) + T(n-1,k) + T(n-1,k+1)
                    trinomialCoefficient[i][j] = trinomialCoefficient[i - 1][j - 1]
                            + trinomialCoefficient[i - 1][j]
                            + trinomialCoefficient[i - 1][j + 1];
                }
            }
        }

        // Handle negative k using symmetry: T(n,k) = T(n,-k)
        if (k < 0) {
            return trinomialCoefficient[n][Math.abs(k)];
        }

        return trinomialCoefficient[n][k];
    }

    /**
     * Takes two integer command-line arguments n and k and prints T(n, k).
     * 
     * @param args Command line arguments:
     *             args[0]: power in the expansion (n)
     *             args[1]: coefficient index (k)
     */
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        System.out.println(trinomial(n, k));
    }
}
