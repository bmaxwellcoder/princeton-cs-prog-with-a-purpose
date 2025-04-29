package week2loops.loops;

/**
 * This program simulates multiple random walks in a 2D grid starting from
 * origin (0,0).
 * For each trial, the walker moves randomly in one of four directions (north,
 * east,
 * south, west) until the Manhattan distance (|x| + |y|) from the origin equals
 * r.
 * The program calculates and displays the average number of steps taken across
 * all trials.
 * 
 * Usage: java RandomWalkers r trials
 * where r is the target Manhattan distance
 * trials is the number of random walks to simulate
 * 
 * @author Bryan Williamson
 */
public class RandomWalkers {

    /**
     * Main method that simulates multiple random walks and calculates average
     * steps.
     * 
     * @param args Command line arguments:
     *             args[0]: target Manhattan distance (r)
     *             args[1]: number of trials to run
     */
    public static void main(String[] args) {
        // Parse the first command line argument as the distance r
        int r = Integer.parseInt(args[0]);
        // Parse the second command line argument as the number of trials
        int trials = Integer.parseInt(args[1]);

        // Initialize the total number of steps taken across all trials
        int totalStepsOfTrials = 0;

        // Perform the random walk for the specified number of trials
        for (int i = 0; i < trials; i++) {
            // Initialize the starting position (x, y)
            int x = 0;
            int y = 0;
            // Continue walking until the Manhattan distance from the origin equals r
            while (Math.abs(x) + Math.abs(y) != r) {
                // Generate a random value between 0.0 inclusive and 1.0 exclusive
                double randomVal = Math.random();
                // Move in one of the four possible directions based on the random value
                if (randomVal < 0.25) {
                    // Move left
                    x++;
                } else if (randomVal < 0.5) {
                    // Move right
                    x--;
                } else if (randomVal < 0.75) {
                    // Move up
                    y++;
                } else {
                    // Move down
                    y--;
                }
                // Increment the total number of steps taken
                totalStepsOfTrials++;
            }
        }

        // Calculate the average number of steps taken per trial
        double averageNumSteps = (double) totalStepsOfTrials / (double) trials;
        // Print the average number of steps
        System.out.println("average number of steps = " + averageNumSteps);
    }
}
