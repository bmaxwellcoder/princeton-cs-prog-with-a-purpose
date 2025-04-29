package Week6_Recursion.recursion;

/**
 * A program that computes trinomial coefficients using a recursive brute-force
 * approach.
 * The program takes two command-line arguments: n and k, and computes the
 * trinomial
 * coefficient T(n, k) using the recursive formula:
 * T(n, k) = T(n-1, k-1) + T(n-1, k) + T(n-1, k+1)
 * 
 * Usage: java TrinomialBrute n k
 * 
 * @author Bryan Williamson
 */
public class TrinomialBrute {

    /**
     * Computes the trinomial coefficient T(n, k) using recursion.
     * 
     * The trinomial coefficient T(n, k) represents the coefficient of x^k in the
     * expansion of (1 + x + x^2)^n.
     * 
     * Recurrence relation:
     * - T(0,0) = 1
     * - T(n,k) = 0 if k < -n or k > n
     * - T(n,k) = T(n-1,k-1) + T(n-1,k) + T(n-1,k+1) otherwise
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

        // Recursive case: T(n,k) = T(n-1,k-1) + T(n-1,k) + T(n-1,k+1)
        return trinomial(n - 1, k - 1) + trinomial(n - 1, k) + trinomial(n - 1, k + 1);
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
