package week3arrays.arrays;

/**
 * This program simulates the birthday paradox problem.
 * It determines how many people need to enter a room before
 * there's a 50% chance that two people share the same birthday.
 * The program runs multiple trials and displays the cumulative probabilities.
 * 
 * Usage: java Birthday n trials
 * where n is the number of possible birthdays (0 to n-1)
 * trials is the number of experiments to run
 * 
 * @author Bryan Williamson
 */
public class Birthday {

    /**
     * Main method that simulates the birthday paradox and displays results.
     * 
     * @param args Command line arguments:
     *             args[0]: number of possible birthdays (n)
     *             args[1]: number of trials to run
     */
    public static void main(String[] args) {
        // Get both command-line arguments
        int n = Integer.parseInt(args[0]); // Number of possible birthdays (0 to n-1)
        int trials = Integer.parseInt(args[1]); // Number of experiments to run

        // Tracks frequency of each room size
        // (how many times exactly i people entered before finding a match)
        // At most n+1 people can enter before a match must occur
        int[] roomSizeFrequency = new int[n + 2];

        // Run the specified number of trials
        int remainingTrials = trials;
        while (remainingTrials > 0) {
            // Track which birthdays have been observed in this trial
            boolean[] birthdaysSeenArr = new boolean[n];
            int personCount = 0; // Number of people who have entered the room

            // Run one experiment until finding a birthday match
            while (true) {
                personCount++; // A new person enters the room
                int birthday = (int) (Math.random() * n); // Random birthday between 0 and n-1

                if (!birthdaysSeenArr[birthday]) {
                    birthdaysSeenArr[birthday] = true; // Record this birthday
                } else {
                    break; // Found a match, experiment ends
                }
            }

            // Record the room size for this experiment
            roomSizeFrequency[personCount]++;
            remainingTrials--;
        }

        // Calculate and print the results table (room size, count, and probability)
        int cumulativeCount = 0;
        for (int i = 1; i < roomSizeFrequency.length; i++) {
            cumulativeCount += roomSizeFrequency[i];
            double probability = (double) cumulativeCount / trials;

            // Format output based on whether this room size occurred
            if (roomSizeFrequency[i] == 0) {
                System.out.println(i + "\t\t" + roomSizeFrequency[i] + "\t\t" + probability);
            } else {
                System.out.println(i + "\t\t" + roomSizeFrequency[i] + "\t" + probability);
            }

            // Stop when we reach 50% probability (answer to the paradox)
            if (probability >= 0.5) {
                break;
            }
        }
    }
}
