package week4io.io;

import stdlib.StdDraw;
/**
 * This program creates an n-by-n checkerboard pattern using standard drawing.
 * The checkerboard alternates between blue and light gray squares, with the
 * bottom-left square being blue. The squares are drawn to fit snugly in the
 * standard drawing window.
 * 
 * Usage: java Checkerboard n
 * where n is the size of the checkerboard (number of squares per side)
 * 
 * @author Bryan Williamson
 */
public class Checkerboard {

    /**
     * Main method that creates and draws an n-by-n checkerboard pattern.
     * 
     * @param args Command line arguments:
     *             args[0]: size of the checkerboard (n)
     */
    public static void main(String[] args) {
        // Parse command-line argument for board size
        int n = Integer.parseInt(args[0]);

        // Set the scale of the drawing canvas to range from 0 to n
        // This ensures the checkerboard fills the entire window
        StdDraw.setScale(0, n);

        // Each square will be 1x1 units, so half-length is 0.5
        // This ensures squares fit snugly in the window
        double halfLength = 0.5;

        // Draw the checkerboard pattern
        // Outer loop for rows (y-coordinate)
        for (int i = 0; i < n; i++) {
            // Inner loop for columns (x-coordinate)
            for (int j = 0; j < n; j++) {
                // Alternate colors based on the sum of row and column indices
                // When sum is even, square is blue; when odd, square is light gray
                if ((i + j) % 2 == 0) {
                    StdDraw.setPenColor(StdDraw.BLUE);
                } else {
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                }

                // Define the offset needed to center squares on integer coordinates
                double offset = 0.5;

                // Draw a filled square at position (j + offset, i + offset)
                // The offset ensures squares are centered on integer coordinates
                StdDraw.filledSquare(j + offset, i + offset, halfLength);
            }
        }
    }
}
