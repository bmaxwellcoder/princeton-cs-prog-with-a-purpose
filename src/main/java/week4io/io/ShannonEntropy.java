package week4io.io;

import stdlib.StdIn;
import stdlib.StdOut;

/**
 * This program calculates the Shannon entropy of a sequence of integers.
 * Shannon entropy is a measure of information content and randomness in a data
 * source.
 * 
 * Formula: H = -Σ(pi * log2(pi)) where:
 * - pi is the proportion of integers with value i
 * - If pi = 0, then pi*log2(pi) = 0
 * 
 * @author Bryan Williamson
 */
public class ShannonEntropy {

    /**
     * Main method that calculates and prints the Shannon entropy of a sequence.
     * 
     * @param args Command line arguments:
     *             args[0]: upper bound for integer values (values must be between 1
     *             and m)
     *             Input sequence of integers should be provided through standard
     *             input
     */
    public static void main(String[] args) {
        // Take a command-line integer m
        int m = Integer.parseInt(args[0]);

        // Step 1: Count frequency of each integer in the range [1,m]
        int[] frequencies = new int[m];

        int totalCount = 0; // Track total number of integers read
        // Read integers from standard input
        while (!StdIn.isEmpty()) {
            int value = StdIn.readInt();
            frequencies[value - 1] += 1; // -1 to adjust for 0-based array indexing
            totalCount++;
        }

        // Step 2: Calculate Shannon entropy using the formula H = -Σ(pi * log2(pi))
        double shannonEntropy = 0.0;

        for (int i = 0; i < m; i++) {
            // Calculate proportion (pi) for each value
            double proportion = ((double) frequencies[i]) / totalCount;

            // Note: When pi = 0, the term pi*log2(pi) = 0 (by convention in information
            // theory)
            if (proportion > 0) {
                // Convert natural log to base-2 log: log2(x) = ln(x)/ln(2)
                shannonEntropy += -(proportion * Math.log(proportion) / Math.log(2));
            }
        }

        // Print the Shannon entropy with exactly 4 decimal places
        StdOut.printf("%.4f\n", shannonEntropy);
    }
}
