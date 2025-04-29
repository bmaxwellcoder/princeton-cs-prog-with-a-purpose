package week2loops.loops;

/**
 * This program calculates the generalized harmonic number of order r to n
 * terms.
 * The generalized harmonic number is defined as:
 * H(n,r) = 1/1^r + 1/2^r + 1/3^r + ... + 1/n^r
 * 
 * When r=1, this gives the standard harmonic series.
 * For different values of r, the series converges or diverges at different
 * rates.
 * 
 * @author Bryan Williamson
 */
public class GeneralizedHarmonic {

    /**
     * Main method that calculates and prints the generalized harmonic number.
     * 
     * @param args Command line arguments:
     *             args[0]: number of terms (n)
     *             args[1]: order of the harmonic number (r)
     */
    public static void main(String[] args) {
        // Parse command line arguments
        int n = Integer.parseInt(args[0]); // Number of terms to sum
        int r = Integer.parseInt(args[1]); // Order of the harmonic number

        // Calculate the generalized harmonic number H(n,r)
        double sum = 0.0;
        for (int i = 1; i <= n; i++) {
            // Add term 1/i^r to the running sum
            sum += 1.0 / Math.pow(i, r);
        }

        // Display the result
        System.out.println(sum);
    }
}
