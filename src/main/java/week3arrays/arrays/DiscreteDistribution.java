package week3arrays.arrays;

/**
 * This program simulates drawing from a discrete distribution.
 * Given an array of probabilities (weights), it samples from the
 * distribution m times and prints the results.
 * 
 * Usage: java DiscreteDistribution m n
 * where m is the number of samples to draw
 * n is the number of weights
 * 
 * @author Bryan Williamson
 */
public class DiscreteDistribution {

    /**
     * Main method that simulates drawing from a discrete distribution.
     * 
     * @param args Command line arguments:
     *             args[0]: number of samples to draw (m)
     *             args[1..n]: weights for the discrete distribution
     */
    public static void main(String[] args) {
        // Parse command-line arguments
        int m = Integer.parseInt(args[0]); // Number of samples to draw

        // Create array with the frequency/weight values
        int[] discreteDistributionVals = new int[args.length - 1]; // -1 to exclude the first argument (m)
        for (int i = 0; i < discreteDistributionVals.length; i++) {
            discreteDistributionVals[i] = Integer.parseInt(args[i + 1]); // +1 to exclude the first argument (m)
        }

        // Calculate cumulative sums for efficient sampling
        int[] cumulativeSums = new int[discreteDistributionVals.length];
        cumulativeSums[0] = discreteDistributionVals[0];
        for (int i = 1; i < cumulativeSums.length; i++) {
            cumulativeSums[i] = cumulativeSums[i - 1] + discreteDistributionVals[i];
        }

        // Generate m samples from the discrete distribution
        int count = 0;
        while (count < m) {
            // Generate random value within the total cumulative sum
            int r = (int) (Math.random() * cumulativeSums[cumulativeSums.length - 1]);

            // Find the appropriate index based on which range r falls into
            int uniqueIdx = 1; // 1-indexed output for the values
            for (int i = 0; i < cumulativeSums.length; i++) {
                if (r < cumulativeSums[i]) {
                    break; // Found the correct range
                }
                uniqueIdx++;
            }

            // Print the selected value
            System.out.print(uniqueIdx + " ");
            count++;
        }

        System.out.println(); // End with a new line
    }
}
