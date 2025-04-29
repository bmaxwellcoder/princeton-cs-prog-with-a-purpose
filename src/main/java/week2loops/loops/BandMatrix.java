package week2loops.loops;

/**
 * This program creates an n×n band matrix where:
 * - Elements within a specified width of the main diagonal are marked with "*"
 * - Elements outside this band are marked with "0"
 * 
 * @author Bryan Williamson
 */
public class BandMatrix {

    /**
     * Main method that generates and prints a band matrix.
     * 
     * @param args Command line arguments:
     *             args[0]: size of the matrix (n)
     *             args[1]: width of the band
     */
    public static void main(String[] args) {
        // Parse command line arguments
        int n = Integer.parseInt(args[0]); // Size of the square matrix
        int width = Integer.parseInt(args[1]); // Width of the band around diagonal

        // Generate and print the band matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Calculate distance from the main diagonal (i == j)
                int distanceFromDiagonal = Math.abs(j - i);

                // Print "*" for elements within the band, "0" for elements outside
                if (distanceFromDiagonal > width) {
                    System.out.print("0  ");
                } else {
                    System.out.print("*  ");
                }
            }
            // Move to the next row
            System.out.println();
        }
    }
}