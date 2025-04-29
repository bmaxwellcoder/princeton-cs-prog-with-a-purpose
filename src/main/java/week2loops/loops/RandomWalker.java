package week2loops.loops;

/**
 * This program simulates a random walk in a 2D grid starting from origin (0,0).
 * The walker moves randomly in one of four directions (north, east, south,
 * west)
 * until the Manhattan distance (|x| + |y|) from the origin equals parameter r.
 * 
 * The program tracks and displays:
 * - Each position in the walk as (x,y) coordinates
 * - The total number of steps taken to reach the target distance
 * 
 * Usage: java RandomWalker r
 * where r is the target Manhattan distance
 * 
 * @author Bryan Williamson
 */
public class RandomWalker {

    /**
     * Main method that simulates a random walk until reaching target distance.
     * 
     * @param args Command line arguments:
     *             args[0]: target Manhattan distance (r)
     */
    public static void main(String[] args) {
        // Parse command line argument
        int r = Integer.parseInt(args[0]); // Target Manhattan distance

        // Initialize walker position and step counter
        int x = 0; // x-coordinate (horizontal position)
        int y = 0; // y-coordinate (vertical position)
        int stepCount = 0;

        // Print initial position
        System.out.println("(" + x + "," + y + ")");

        // Continue walking until Manhattan distance equals r
        while (Math.abs(x) + Math.abs(y) != r) {
            // Choose a random direction
            double randomVal = Math.random();

            // Move in one of four directions with equal probability
            if (randomVal < 0.25) {
                // Move east (increase x)
                x++;
            } else if (randomVal < 0.5) {
                // Move west (decrease x)
                x--;
            } else if (randomVal < 0.75) {
                // Move north (increase y)
                y++;
            } else {
                // Move south (decrease y)
                y--;
            }

            // Increment step count and print new position
            stepCount++;
            System.out.println("(" + x + "," + y + ")");
        }

        // Print final step count
        System.out.println("steps = " + stepCount);
    }
}
