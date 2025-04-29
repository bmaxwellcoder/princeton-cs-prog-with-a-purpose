package Week6_Recursion.recursion;

import stdlib.StdDraw;

/**
 * This class draws a recursive pattern of squares where each level n contains:
 * - A central square
 * - Four smaller squares of order n-1 at each corner
 * The pattern demonstrates recursive subdivision of space.
 * 
 * @author Bryan Williamson
 */
public class RecursiveSquares {

    /**
     * Draws a single square with light gray fill and black border.
     * 
     * @param x      x-coordinate of square center
     * @param y      y-coordinate of square center
     * @param length side length of the square
     */
    public static void drawSquare(double x, double y, double length) {
        // Draw filled square with light gray background
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledSquare(x, y, 0.5 * length);

        // Draw black border
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(x, y, 0.5 * length);
    }

    /**
     * Recursively draws a pattern of squares of order n.
     * The pattern consists of a central square surrounded by four smaller patterns.
     * 
     * @param n      order of the pattern (recursion depth)
     * @param x      x-coordinate of center
     * @param y      y-coordinate of center
     * @param length side length of the current level
     */
    public static void draw(int n, double x, double y, double length) {
        // Base case: stop recursion when n reaches 0
        if (n == 0) {
            return;
        }

        // Recursively draw four smaller patterns at the corners
        // Each recursive call uses half the length of the parent
        draw(n - 1, x - length / 2, y + length / 2, length / 2); // top left
        draw(n - 1, x + length / 2, y + length / 2, length / 2); // top right
        drawSquare(x, y, length); // draw center square
        draw(n - 1, x - length / 2, y - length / 2, length / 2); // bottom left
        draw(n - 1, x + length / 2, y - length / 2, length / 2); // bottom right
    }

    /**
     * Main method to draw the recursive squares pattern.
     * Takes an integer command-line argument n for the pattern order.
     * The pattern is centered at (0.5, 0.5) with initial side length 0.5.
     * 
     * @param args Command line arguments:
     *             args[0]: order of the pattern (n)
     */
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        draw(n, 0.5, 0.5, 0.5);
    }
}
