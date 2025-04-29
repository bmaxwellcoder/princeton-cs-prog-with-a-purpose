package week3arrays.arrays;

/**
 * This program generates an n-by-n pattern using the Thue-Morse sequence.
 * The Thue-Morse sequence is a binary sequence with interesting properties:
 * - t(0) = 0
 * - t(2n) = t(n)
 * - t(2n+1) = 1-t(n)
 *
 * The program displays a pattern where cells use:
 * - "+" if the bit values at positions i and j are equal
 * - "-" if the bit values at positions i and j are different
 * 
 * Usage: java ThueMorse n
 * where n is the size of the pattern (n-by-n)
 * 
 * @author Bryan Williamson
 */
public class ThueMorse {

    /**
     * Main method that generates and displays an n-by-n Thue-Morse pattern.
     * 
     * @param args Command line arguments:
     *             args[0]: size of the pattern (n)
     */
    public static void main(String[] args) {
        // Parse command-line argument
        // May assume that n is a positive integer
        // (but it need not be a power of 2)
        int n = Integer.parseInt(args[0]);

        // Solution 1:
        boolean[] thueMorseBoolSeq = new boolean[n * n];
        for (int i = 1; i < thueMorseBoolSeq.length; i++) {
            for (int j = 0; j < i; j++) {
                thueMorseBoolSeq[i + j] = !thueMorseBoolSeq[j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (thueMorseBoolSeq[i] == thueMorseBoolSeq[j]) {
                    System.out.print("-  ");
                } else {
                    System.out.print("+  ");
                }
            }
            System.out.println();
        }

        // Create array to store Thue-Morse sequence values
        int[] bitValue = new int[n]; // Creates array of length n with default value(s) of zero

        // Generate the Thue-Morse sequence for indices 0 through n-1
        // Applied formula: thue[i] = 0 if i=0, thue[i/2] if i is even, 1-thue[i-1] if i
        // is odd
        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                bitValue[i] = bitValue[i / 2]; // For even indices, copy from half the index
            } else {
                bitValue[i] = 1 - bitValue[i - 1]; // For odd indices, flip the previous value
            }
        }

        // Create an n-by-n pattern by comparing bit values:
        // - Print "+" if bits i and j in the sequence are equal
        // - Print "-" if bits i and j in the sequence are different
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (bitValue[i] == bitValue[j]) {
                    System.out.print("+  "); // Equal bit values
                } else {
                    System.out.print("-  "); // Different bit values
                }
            }
            System.out.println(); // Move to the next row
        }
    }
}
